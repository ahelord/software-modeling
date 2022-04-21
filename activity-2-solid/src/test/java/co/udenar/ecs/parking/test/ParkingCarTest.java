/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.udenar.ecs.parking.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import co.udenar.ecs.parking.domain.Parking;
import co.udenar.ecs.parking.domain.ParkingCar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author fruales
 */
public class ParkingCarTest extends TestCase{
    Parking parkingCarOne = new ParkingCar();
    Parking parkingCarTwo = new ParkingCar();
    Parking parkingCarTree = new ParkingCar();
    
        
    
      @Before
    
     
        public void setUp() throws Exception {
    	parkingCarOne.calculateCost(
                        
        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:01:01"));
    	
    	parkingCarTwo.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:31:01")
        );
        
            	
    	parkingCarTree.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 08:30:00")
        );
        }
        
        @Test
    public void testCalculateHoursBetweenDatesCOne() throws ParseException {
    	assertEquals(1, parkingCarOne.calculateHoursBetweenDates(
    			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:01:01")), 0.0);
    }
    
    @Test
    public void testCalculateHoursBetweenDatesCTwo() throws ParseException {
    	assertEquals(0.5, parkingCarOne.calculateHoursBetweenDates(
    			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:31:01")), 0.0);
    }
    
    @Test
    public void testCalculateHoursBetweenDatesCTree() throws ParseException {
    	assertEquals(1.5, parkingCarOne.calculateHoursBetweenDates(
    			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 08:30:00")), 0.0);
    }
    @Test
    public void testCostCarOne() {
    	assertEquals(2000, parkingCarOne.getCost(),0.0);
    }
    
    @Test
    public void testCostCarTwo() {
    	assertEquals(2000, parkingCarTwo.getCost(),0.0);
    }
    
    @Test
    public void testCostCarTree() {
    	assertEquals(3000, parkingCarTree.getCost(),0.0);
    }
    
    
}

    
    
    

