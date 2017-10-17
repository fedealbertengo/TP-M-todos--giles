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
    
}
