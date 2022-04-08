import java.text.SimpleDateFormat;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViajeTodoIncluidoTest extends TestCase {
    private ViajeTodoIncluido viajeTodoIncluido;

    @Before
    public void setUp() throws Exception {
        viajeTodoIncluido = new ViajeTodoIncluido("Popayán", "Cartagena", 7350000,
                    new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new
                    SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
    }

    @Test
    public void testCantidadDias() {
        assertEquals(11.0, viajeTodoIncluido.cantidadDias(),0.0);
    }

    @Test
    public void testDescripcion() {
        assertEquals("Disfruta tu viaje todo incluido", viajeTodoIncluido.descripcion());
    }
    @Test
    public void testObtenerCostoConIva() {
        assertEquals(8526000.0,viajeTodoIncluido.obtenerCostoConIva(),0.0);
    }
}
