package CDatos;

import CEntidades.Titular;
import java.util.ArrayList;

public class TitularDB {
    
    public static Titular getTitular(long idTitu) throws Exception{
        try{
            String consulta = "SELECT * FROM Titular WHERE ID = " + idTitu;
            ArrayList<Titular> ls = (ArrayList<Titular>)((Object)Conexion.consultar(consulta, Titular.class));
            return (ls.size() > 0) ? ls.get(0) : null;
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public static void altaTitular(Titular tit) throws Exception {
        try{
            String query = "INSERT INTO Titular (Apellido, Nombre, TipoDocumento, NumeroDocumento, FechaNacimiento, Direccion, GrupoSanguineo, FactorRH, Donante, FechaCreacion, FechaBaja, IdUsuario) VALUES (" + 
                    "'" + tit.Apellido + "'" + ", " +
                    "'" + tit.Nombre + "'" + ", " +
                    "'" + tit.TipoDocumento + "'" + ", " +
                    tit.NumeroDocumento + ", " +
                    "'" + tit.FechaNacimiento + "'" + ", " +
                    "'" + tit.Direccion + "'" + ", " +
                    "'" + tit.GrupoSanguineo + "'" + ", " +
                    (tit.FactorRH ? 1 : 0) + ", " +
                    (tit.Donante ? 1 : 0) + ", " +
                    "'" + tit.FechaCreacion + "'" + ", " +
                    "NULL" + ", " +
                     tit.IdUsuario +
                    ")";
            Conexion.ejecutarSentencia(query);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
