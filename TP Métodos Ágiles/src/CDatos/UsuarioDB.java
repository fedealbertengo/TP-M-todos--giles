package CDatos;
import CEntidades.*;
import java.util.ArrayList;

public class UsuarioDB {
    
    public static Usuario getUsuario(long idUsu) throws Exception{
        try{
            return ((ArrayList<Usuario>)(Object)Conexion.consultar("SELECT * FROM Usuario WHERE ID = " + idUsu, Usuario.class)).get(0);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
