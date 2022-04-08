import java.text.SimpleDateFormat;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ViajeIncentivoTest extends TestCase{
	private ViajeIncentivo viajeIncentivo;

    @Before
    public void setUp() throws Exception {
        viajeIncentivo = new ViajeIncentivo("Popayán", "Medellin", 2100000, new
                SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new
                SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
    }
    
    @Test
    public void testCantidadDias() {
        assertEquals(10.0, viajeIncentivo.cantidadDias(),0.0);
    } 
    
    @Test
    public void testDescripcion() {
        assertEquals("Viaje incentivo que te envia la empresa " + viajeIncentivo.getEmpresa(), viajeIncentivo.descripcion());
    }
    
    @Test
    public void testObtenerCostoConIva() {
        assertEquals(2436000.0, viajeIncentivo.obtenerCostoConIva(),0.0);
    }
}
