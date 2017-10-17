package CDatos;

import CEntidades.Licencia;
import java.util.ArrayList;

public class LicenciaDB {
    
    public static Licencia getLicencia(long idLic) throws Exception{
        try{
            String query = "SELECT * FROM Licencia WHERE ID = " + idLic;
            ArrayList<Licencia> ls = (ArrayList<Licencia>)((Object)Conexion.consultar(query, Licencia.class));
            return (ls.size() > 0) ? ls.get(0) : null;
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
    
    public static ArrayList<Licencia> getRenovaciones(long idLic) throws Exception{
        try{
            return ((ArrayList<Licencia>)(Object)Conexion.consultar("SELECT * FROM Licencia WHERE IdOriginal = " + idLic, Licencia.class));
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static void altaLicencia(Licencia lic) throws Exception{
        
        try{
            String query = "INSERT INTO Licencia (IdTitular, Clase, FechaEmision, FechaExpiracion, IdUsuario, IdOriginal) VALUES (" + 
                    lic.IdTitular + ", " +
                    "'" + lic.Clase + "'" + ", " +
                    "'" + lic.FechaEmision + "'" + ", " +
                    "'" + lic.FechaExpiracion + "'" + ", " +
                    lic.IdUsuario + ", " +
                    ((lic.IdOriginal.intValue() == -1)? "NULL" : lic.IdOriginal) +
                    ")";
            Conexion.ejecutarSentencia(query);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public static Long getIdOriginal(Long id) throws Exception{
        try{
            ArrayList<Licencia> licencias = (ArrayList<Licencia>)(Object)Conexion.consultar("SELECT * FROM Licencia WHERE IdTitular = " + id +" AND IdOriginal = null", Licencia.class);
            return (!licencias.isEmpty())? licencias.get(0).getIdTitular() : new Long(-1);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
