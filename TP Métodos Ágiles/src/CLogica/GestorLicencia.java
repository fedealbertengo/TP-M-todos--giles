package CLogica;

import CDatos.Conexion;
import CDatos.LicenciaDB;
import CEntidades.Licencia;
import CEntidades.Titular;
import java.time.LocalDate;
import java.util.Date;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorLicencia {
    
    public static Licencia getLicencia(long idLic) throws Exception{
        try{
            return LicenciaDB.getLicencia(idLic);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static Long recuperarIdOriginal(Long id) throws Exception{
            
        try{
            return LicenciaDB.getIdOriginal(id);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static ArrayList<Licencia> getLicenciasTitular(long idTit) throws Exception{
        try{
            return LicenciaDB.getLicenciasTitular(idTit);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static ArrayList<Licencia> getRenovaciones(long idLic) throws Exception{
        try{
            return LicenciaDB.getRenovaciones(idLic);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    private static boolean validarLicencia(){
        //TODO: Hacer el método
        return true;
    }
    
    public static void altaLicencia(Licencia lic) throws Exception{
        try{
            if(validarLicencia()){
                LicenciaDB.altaLicencia(lic);
            }
            else{
                throw new Exception("La licencia no contiene datos válidos.");
            }
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public static java.sql.Date calcularFechaExpiracion(char clase, long idTitular) throws Exception {
        try {
            Titular titu = GestorTitular.getTitular(idTitular);
            Long edad = GestorUtilidades.getAge(titu.getFechaNacimiento());
            boolean esPrimera = GestorLicencia.recuperarIdOriginal(idTitular) == -1;
            int anio = Year.now().getValue();
            if(edad < 21){
                if(esPrimera){
                    anio += 1;
                }else{
                    anio += 3;
                }
            }else if (edad < 46){
                anio += 5;
            }else if (edad < 60){
                anio += 4;
            }else if (edad < 70){
                anio += 3;
            }else{
                anio += 1;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(titu.getFechaNacimiento());
            cal.set(Calendar.YEAR, anio);
            LocalDate ld = cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date fecha = java.sql.Date.valueOf(ld);
            return fecha;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void validarLicencia(Licencia licencia) throws Exception{
        boolean flag_faltaB = false;
        boolean flag_menor21 = false;
        boolean flag_primeraMayor65 = false;
        boolean flag_menor17 = false;
        String cadenaError = "";
 
        if(licencia.Clase == 'C' || licencia.Clase == 'D' || licencia.Clase == 'E'){
            
            if(licencia.IdOriginal == null){
                flag_faltaB = true;
            
            }else{
                
                Titular titu = GestorTitular.getTitular(licencia.getIdTitular());
                Long edad = GestorUtilidades.getAge(titu.getFechaNacimiento());
                
                if(edad < 21)
                    flag_menor21 = true;
                
                ArrayList<Licencia> licencias = GestorLicencia.getLicenciasTitular(titu.ID);
                ListIterator<Licencia> itLicencias = licencias.listIterator();
                
                flag_faltaB = true;
                while(itLicencias.hasNext() && flag_faltaB){
                    Licencia actual = itLicencias.next();
                    if(actual.Clase == 'B' && (GestorUtilidades.getAge(actual.FechaEmision) <= 1)) 
                        //Tiene una licencia tipo B con al menos un anio de antiguedad
                        flag_faltaB = false;
                }
                
                if(edad > 65){
                    itLicencias = licencias.listIterator();
                    flag_primeraMayor65 = true;
                    while(itLicencias.hasNext() && flag_primeraMayor65){
                        Licencia actual = itLicencias.next();
                        if(actual.Clase == licencia.Clase){
                            //No es primera vez, esta renovando su licencia
                            flag_primeraMayor65 = false;
                        }
                    }
                }
            }
        }else{
            Titular titu = GestorTitular.getTitular(licencia.getIdTitular());
            Long edad = GestorUtilidades.getAge(titu.getFechaNacimiento());
            if(edad < 17)
                flag_menor17 = true;
        }
       
        if(flag_faltaB)
            cadenaError += "No puede crearse una licencia clase " + licencia.Clase + " sin tener una licencia clase B\n";
        if(flag_menor21)
            cadenaError += "No puede crearse una licencia clase " + licencia.Clase + " siendo menor de 21 años\n";
        if(flag_primeraMayor65)
            cadenaError += "No puede crearse una licencia clase " + licencia.Clase + " por primera vez siendo mayor de 65 años\n";
        if(flag_menor17)
            cadenaError += "No puede crearse una licencia clase " + licencia.Clase + " siendo menor de 17 años\n";            
        if(flag_faltaB || flag_menor21 || flag_primeraMayor65 || flag_menor17){
            throw new Exception(cadenaError);
        }
    }
    
    public static boolean licenciaExpirada(Licencia lic){
        return true;
    }
}
