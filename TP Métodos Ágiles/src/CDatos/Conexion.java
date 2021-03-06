/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import CEntidades.*;

/**
 *
 * @author fede_
 */
public class Conexion {
    public static Connection conectar(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://tpmetodosagiles.database.secure.windows.net:1433;databaseName=TPMetodosAgiles;user=FedeAlb;password=metodosagiles12!;";
            Connection conect = DriverManager.getConnection(connectionUrl);
            return conect;
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static ArrayList<Object> consultar(String query, Class<? extends Object> ob) throws Exception{
        ArrayList<Object> result = new ArrayList<Object>();
        Connection con = null;
        try {
            con = Conexion.conectar();
            ResultSet rs = con.createStatement().executeQuery(query);
            String objeto;
            while(rs.next()){
                objeto = "";
                if(ob == ConsultaGenerica.class){
                    for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                        objeto += rs.getMetaData().getColumnName(i) + " - " + rs.getString(i) + "\t";
                    }
                }
                else{
                    for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                        objeto += rs.getString(i) + "\t";
                    }
                }
                Object obj = ob.getConstructor(String.class).newInstance(objeto);
                result.add(obj);
            }
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
            return result;
        }
    }
    
    public static void ejecutarSentencia(String query) throws Exception{
        Connection con = null;
        try {
            con = Conexion.conectar();
            con.createStatement().executeUpdate(query);
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
        }
    }
}
