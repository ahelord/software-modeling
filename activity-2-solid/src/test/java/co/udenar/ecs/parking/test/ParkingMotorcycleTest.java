package co.udenar.ecs.parking.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Before;
import org.junit.Test;

import co.udenar.ecs.parking.domain.Parking;
import co.udenar.ecs.parking.domain.ParkingMotorcycle;
import junit.framework.TestCase;

public class ParkingMotorcycleTest extends TestCase{
	Parking parkingMotorcycleOne = new ParkingMotorcycle();
	Parking parkingMotorcycleTwo = new ParkingMotorcycle();
    Parking parkingMotorcycleTree = new ParkingMotorcycle();
    
    @Before
    public void setUp() throws Exception {
    	parkingMotorcycleOne.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 14:31:01"));
    	
    	parkingMotorcycleTwo.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:31:01")
        );
    	
    	parkingMotorcycleTree.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 12:45:00")
        );
    }
    
    @Test
    public void testCalculateHoursBetweenDatesMOne() throws ParseException {
    	assertEquals(4.5, parkingMotorcycleOne.calculateHoursBetweenDates(
    			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 14:31:01")), 0.0);
    }
    
    @Test
    public void testCalculateHoursBetweenDatesMTwo() throws ParseException {
    	assertEquals(1.5, parkingMotorcycleOne.calculateHoursBetweenDates(
    			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:31:01")), 0.0);
    }
    
    @Test
    public void testCalculateHoursBetweenDatesMTree() throws ParseException {
    	assertEquals(5.75, parkingMotorcycleOne.calculateHoursBetweenDates(
    			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 12:45:00")), 0.0);
    }
    
    @Test
    public void testCostMotorcycleOne() {
    	assertEquals(4500, parkingMotorcycleOne.getCost(),0.0);
    }
    
    @Test
    public void testCostMotorcycleTwo() {
    	assertEquals(3000, parkingMotorcycleTwo.getCost(),0.0);
    }
    
    @Test
    public void testCostMotorcycleTree() {
    	assertEquals(5750, parkingMotorcycleTree.getCost(),0.0);
    }
    
    
}
