/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLogica;

import CDatos.CostoDB;
import CEntidades.Costo;
import CEntidades.Licencia;

/**
 *
 * @author admin
 */
public class GestorCosto {
    
    public static Long calcularCosto(Licencia lic, boolean esCopia) throws Exception{
        Long costoAdministrativo = new Long(8);
        Long costoCopia = new Long(50);
        
        if(esCopia){
            return costoCopia;
        }else{
            Costo c = CostoDB.getCostoLicencia(lic).get(0);
            return ((Double) c.getCosto()).longValue() + costoAdministrativo;
        } 
    }
}
