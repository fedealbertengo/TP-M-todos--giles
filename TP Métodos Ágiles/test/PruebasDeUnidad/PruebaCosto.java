package PruebasDeUnidad;

import CDatos.CostoDB;
import CEntidades.Costo;
import CEntidades.Licencia;
import CLogica.GestorCosto;
import CLogica.GestorLicencia;
import CLogica.GestorTitular;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fede_
 */
public class PruebaCosto {
    
    public PruebaCosto() {
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
    public void testearListaCostos() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dateFormat.format(new java.util.Date());
        String fechaExpiracion = "2022-11-01";
        java.sql.Date fechaAct = java.sql.Date.valueOf(fechaActual);
        java.sql.Date fechaExp = java.sql.Date.valueOf(fechaExpiracion);
        Licencia lic = new Licencia(new Long(0), new Long(1), 'A', fechaAct, fechaExp, new Long(1), null, false);
        assertEquals("", 1, CostoDB.getCostoLicencia(lic).size());
    }
    
    @Test
    public void testearCosto() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dateFormat.format(new java.util.Date());
        String fechaExpiracion = "2022-11-01";
        java.sql.Date fechaAct = java.sql.Date.valueOf(fechaActual);
        java.sql.Date fechaExp = java.sql.Date.valueOf(fechaExpiracion);
        Licencia lic = new Licencia(new Long(0), new Long(1), 'A', fechaAct, fechaExp, new Long(1), null, false);
        assertEquals("Costo = 48", new Long(48), GestorCosto.calcularCosto(lic, false));
    }    
    
}
