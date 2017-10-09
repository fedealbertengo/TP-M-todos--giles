package CDatos;

import CEntidades.Titular;
import java.util.ArrayList;

public class TitularDB {
    
    public static Titular getTitular(long idTitu) throws Exception{
        try{
            return ((ArrayList<Titular>)(Object)Conexion.consultar("SELECT * FROM Titular WHERE ID = " + idTitu, Titular.class)).get(0);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
