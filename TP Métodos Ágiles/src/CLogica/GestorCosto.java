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
    
    public static Costo getCostoLicencia(Licencia lic) throws Exception{
        return CostoDB.getCostoLicencia(lic).get(0);
    }
}
