package PruebasDeUnidad;

import CEntidades.Licencia;
import CLogica.GestorCosto;
import CLogica.GestorLicencia;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaFechaExpiracion {
    
    public PruebaFechaExpiracion() {
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
    public void testearFechaExpiracion() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEsp = "2022-03-08";
        java.sql.Date fechaEsperada = java.sql.Date.valueOf(fechaEsp);
        assertEquals("Costo = 48", fechaEsperada, GestorLicencia.calcularFechaExpiracion('A', 2));
    }    
}
