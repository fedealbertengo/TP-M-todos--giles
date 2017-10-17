/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDatos;

import CEntidades.Costo;
import java.util.ArrayList;
import CEntidades.Licencia;
import java.time.Year;
import java.util.Calendar;

/**
 *
 * @author admin
 */
public class CostoDB {
    
    public static ArrayList<Costo> getCostoLicencia(Licencia lic) throws Exception{
        try{
            char clase=lic.Clase;
            Calendar cal = Calendar.getInstance();
            int anio = Year.now().getValue();
            cal.setTime(lic.getFechaExpiracion());
            double vigencia=cal.get(Calendar.YEAR)- anio;
            return ((ArrayList<Costo>)(Object)Conexion.consultar("SELECT * FROM Costo WHERE Clase = " + clase + " AND Vigencia = " + vigencia, Licencia.class));
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
