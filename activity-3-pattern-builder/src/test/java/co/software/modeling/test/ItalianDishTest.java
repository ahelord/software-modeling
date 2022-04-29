package co.software.modeling.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import co.software.modeling.domain.Dish;
import co.software.modeling.domain.DishDirector;
import co.software.modeling.domain.ItalianDish;
import co.software.modeling.domain.ItalianDishBuilder;
import co.software.modeling.domain.Size;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fruales
 */
public class ItalianDishTest {
    	DishDirector dir4 = new DishDirector();
        ArrayList<Dish> italianMenu = new ArrayList<>();

    public ItalianDishTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        dir4.setBuilder(new ItalianDishBuilder());
        dir4.create("Spaghetti Amatriciana","https://okdiario.com/img/recetas/2017/04/04/espaguetis-amatriciana-00.jpg", Size.DOUBLE);
        italianMenu.add(dir4.getDish());
    }
    
    /**
     * Test of getPrice method, of class ItalianDish.
     */
     
    @Test
    public void testDishPartsCant() throws ParseException {
    	Assert.assertEquals(2.0, italianMenu.get(0).getOptions().size(), 0.0);
    }
        
       
    @Test
    public void testGetPrice() {
    	Assert.assertEquals(40035.0, italianMenu.get(0).getPrice(), 0.0);
    }
    
}
