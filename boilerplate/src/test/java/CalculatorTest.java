import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class CalculatorTest {
    private Calculator calculator;

    @Before
   public void setUp() throws Exception {
        calculator = new Calculator();
    }

     @Test
     public void testMultiply() {
        assertEquals( "Regular multiplication should work", calculator.multiply(4,5), 20);
    }

     @Test
     public void testMultiplyWithZero() {
        assertEquals("Multiple with zero should be zero",0,  calculator.multiply(0,5));
        assertEquals("Multiple with zero should be zero", 0, calculator.multiply(5,0));
    }
}
