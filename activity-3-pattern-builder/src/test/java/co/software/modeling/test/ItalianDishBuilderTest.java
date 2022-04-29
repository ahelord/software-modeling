package co.software.modeling.test;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.software.modeling.domain.Dish;
import co.software.modeling.domain.DishDirector;
import co.software.modeling.domain.ItalianDishBuilder;
import co.software.modeling.domain.Size;

public class ItalianDishBuilderTest {
	DishDirector director1 = new DishDirector();
	DishDirector director2 = new DishDirector();
	DishDirector director3 = new DishDirector();
	ArrayList<Dish> italianMenu = new ArrayList<>();
	
    @Before
    public void setUp() throws Exception {
    	
    	director1.setBuilder(new ItalianDishBuilder());
        director1.create("Spaghetti Amatriciana","https://okdiario.com/img/recetas/2017/04/04/espaguetis-amatriciana-00.jpg", Size.FAMILY);
        italianMenu.add(director1.getDish());
                       
    }
    
    @Test
    public void testDishesQuantityPlatos() throws ParseException {
    	Assert.assertEquals(1, italianMenu.size(), 0.0);
    }
    
    @Test
    public void testDishPartsQuantity() throws ParseException {
    	Assert.assertEquals(2, italianMenu.get(0).getOptions().size(), 0.0);
    }
        
    @Test
    public void testSizeDish() throws ParseException {    	
    	Assert.assertEquals(Size.FAMILY, italianMenu.get(0).getSize());
    }
    
    @Test
    public void testPrice() {
    	Assert.assertEquals(80070.0, italianMenu.get(0).getPrice(), 0.0);
    }
    
    
}
