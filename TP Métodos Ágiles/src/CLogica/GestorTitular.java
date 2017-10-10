package CLogica;

import CDatos.TitularDB;
import CEntidades.Titular;

public class GestorTitular {
    
    public static Titular getTitular(long idTitu) throws Exception{
        try{
            return TitularDB.getTitular(idTitu);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
    
    public static void altaTitular(Titular tit) throws Exception{
        try{
            TitularDB.altaTitular(tit);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
