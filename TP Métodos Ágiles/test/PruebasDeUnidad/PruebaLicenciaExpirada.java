/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasDeUnidad;

import CEntidades.Licencia;
import CLogica.GestorLicencia;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaLicenciaExpirada {
    
    public PruebaLicenciaExpirada() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testearLicenciaNoExpirada() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dateFormat.format(new java.util.Date());
        String fechaExpiracion = "2022-11-01";
        java.sql.Date fechaAct = java.sql.Date.valueOf(fechaActual);
        java.sql.Date fechaExp = java.sql.Date.valueOf(fechaExpiracion);
        Licencia lic = new Licencia(new Long(0), new Long(1), 'A', fechaAct, fechaExp, new Long(1), null, false);
        assertEquals("Prueba 1", false, GestorLicencia.licenciaExpirada(lic));
    }    
    
    @Test 
    public void testearLicenciaExpirada() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dateFormat.format(new java.util.Date());
        String fechaExpiracion = "2017-10-31";
        java.sql.Date fechaAct = java.sql.Date.valueOf(fechaActual);
        java.sql.Date fechaExp = java.sql.Date.valueOf(fechaExpiracion);
        Licencia lic = new Licencia(new Long(0), new Long(1), 'A', fechaAct, fechaExp, new Long(1), null, false);
        assertEquals("Prueba 2", true, GestorLicencia.licenciaExpirada(lic));
    }
    
}
