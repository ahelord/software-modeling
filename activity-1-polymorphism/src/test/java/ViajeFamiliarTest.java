import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class ViajeFamiliarTest {
    private ViajeFamiliar viajeFamiliar;

    @Before
    public void setUp() throws Exception {
        viajeFamiliar = new ViajeFamiliar("Popayán", "Bogotá", 1250000, new
                SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), new
                SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), 5);
    }

    @Test
    public void testCantidadDias() {
        assertEquals(6.0, viajeFamiliar.cantidadDias(),0.0);
    }

    @Test
    public void testDescripcion() {
        assertEquals("Viaje para disfrutar con toda tu familia", viajeFamiliar.descripcion());
    }
    @Test
    public void testObtenerCostoConIva() {
        assertEquals(1450000.0,viajeFamiliar.obtenerCostoConIva(),0.0);
    }

}