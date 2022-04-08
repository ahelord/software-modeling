import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ViajeIndividualTest extends TestCase{
	private ViajeIndividual viajeIndividual;

    @Before
    public void setUp() throws Exception {
    	viajeIndividual = new ViajeIndividual("Popayán", "San Andres", 4250000,
                new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new
                SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
    }
    
    @Test
    public void testCantidadDias() {
        assertEquals(11.0, viajeIndividual.cantidadDias(),0.0);
    } 
    
    @Test
    public void testDescripcion() {
        assertEquals("Disfruta tu viaje individual", viajeIndividual.descripcion());
    }
    
    @Test
    public void testObtenerCostoConIva() {
        assertEquals(4930000.0, viajeIndividual.obtenerCostoConIva(),0.0);
    }
}
