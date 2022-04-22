
package co.udenar.ecs.parking.test;

import co.udenar.ecs.parking.domain.Parking;
import co.udenar.ecs.parking.domain.ParkingCar;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParkingCarTest {
    Parking parkingCarOne = new ParkingCar();
    Parking parkingCarTwo = new ParkingCar();
    Parking parkingCarTree = new ParkingCar();


    @Before


    public void setUp() throws Exception {
        parkingCarOne.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:01:01")
        );

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
        Assert.assertEquals(1, parkingCarOne.calculateHoursBetweenDates(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:01:01")), 0.0);
    }

    @Test
    public void testCalculateHoursBetweenDatesCTwo() throws ParseException {
        Assert.assertEquals(0.5, parkingCarOne.calculateHoursBetweenDates(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:31:01")), 0.0);
    }

    @Test
    public void testCalculateHoursBetweenDatesCTree() throws ParseException {
        Assert.assertEquals(1.5, parkingCarOne.calculateHoursBetweenDates(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 07:00:00"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 08:30:00")), 0.0);
    }

    @Test
    public void testCostCarOne() {
        Assert.assertEquals(2000, parkingCarOne.getCost(), 0.0);
    }

    @Test
    public void testCostCarTwo() {
        Assert.assertEquals(2000, parkingCarTwo.getCost(), 0.0);
    }

    @Test
    public void testCostCarTree() {
        Assert.assertEquals(3000, parkingCarTree.getCost(), 0.0);
    }


}

    
    
    

