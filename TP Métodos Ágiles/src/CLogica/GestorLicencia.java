package CLogica;

import CDatos.LicenciaDB;
import CEntidades.Licencia;
import java.util.ArrayList;

public class GestorLicencia {
    
    public static Licencia getLicencia(long idLic) throws Exception{
        try{
            return LicenciaDB.getLicencia(idLic);
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
    
}
