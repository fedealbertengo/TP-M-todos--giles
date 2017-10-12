package CDatos;
import CEntidades.*;
import java.util.ArrayList;

public class UsuarioDB {
    
    public static Usuario getUsuario(long idUsu) throws Exception{
        try{
            String query = "SELECT * FROM Usuario WHERE ID = " + idUsu;
            ArrayList<Usuario> ls = (ArrayList<Usuario>)((Object)Conexion.consultar(query, Usuario.class));
            return (ls.size() > 0) ? ls.get(0) : null;
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
