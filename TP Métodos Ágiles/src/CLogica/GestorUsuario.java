package CLogica;
import CEntidades.*;
import CDatos.UsuarioDB;

public class GestorUsuario {
    
    public static Usuario getUsuario(long idUsu) throws Exception{
        try{
            return UsuarioDB.getUsuario(idUsu);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
