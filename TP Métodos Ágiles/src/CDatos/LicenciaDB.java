package CDatos;

import CEntidades.Licencia;
import java.util.ArrayList;

public class LicenciaDB {
    
    public static Licencia getLicencia(long idLic) throws Exception{
        try{
            return ((ArrayList<Licencia>)(Object)Conexion.consultar("SELECT * FROM Licencia WHERE ID = " + idLic, Licencia.class)).get(0);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static ArrayList<Licencia> getLicenciasTitular(long idTit) throws Exception{
        try{
            return ((ArrayList<Licencia>)(Object)Conexion.consultar("SELECT * FROM Licencia WHERE IdTitular = " + idTit, Licencia.class));
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
