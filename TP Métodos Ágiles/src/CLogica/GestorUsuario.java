package CLogica;
import CEntidades.*;
import CDatos.UsuarioDB;

public class GestorUsuario {
    
    public static Usuario usuarioLogeado;
    
    public static Usuario getUsuario(long idUsu) throws Exception{
        try{
            return UsuarioDB.getUsuario(idUsu);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
    
    public static Usuario getUsuarioLogeado(){
        return usuarioLogeado;
    }
    
    public static void setUsuarioLogeado(Usuario usu){
        usuarioLogeado = usu;
    }
}
