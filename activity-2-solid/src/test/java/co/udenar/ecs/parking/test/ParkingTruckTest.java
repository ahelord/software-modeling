
package co.udenar.ecs.parking.test;

import co.udenar.ecs.parking.domain.Parking;
import co.udenar.ecs.parking.domain.ParkingTruck;
import co.udenar.ecs.parking.domain.Raffle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingTruckTest {
    Raffle mockedRaffle = mock(Raffle.class);


    @Before

    public void setUp() throws Exception {
    }

    @Test
    public void testCalculateHoursBetweenDates() throws ParseException {
        Parking parkingTruckTwo = new ParkingTruck(mockedRaffle, 1);
        Assert.assertEquals(1, parkingTruckTwo.calculateHoursBetweenDates(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:01:01")
        ), 0.0);
    }


    @Test
    public void testCalculateCostWhenIsWinnerRaffle() throws Exception {
        Parking parkingTruckOne = new ParkingTruck(mockedRaffle, 1);
        when(mockedRaffle.getWinnerNumber()).thenReturn(1);
        parkingTruckOne.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:01:01")
        );
        Assert.assertEquals(2000, parkingTruckOne.getCost(), 0.0);
    }

    @Test
    public void testCalculateCostWhenNotWinnerRaffleAndParkedOneDay() throws Exception {
        Parking parkingTruckTwo = new ParkingTruck(mockedRaffle, 2);
        when(mockedRaffle.getWinnerNumber()).thenReturn(1);
        parkingTruckTwo.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("02/05/2019 10:01:01")
        );
        Assert.assertEquals(15000, parkingTruckTwo.getCost(), 0.0);
    }

    @Test
    public void testCalculateCostWhenNotWinnerRaffleAndParkedLessOneDay() throws Exception {
        Parking parkingTruckTwo = new ParkingTruck(mockedRaffle, 2);
        when(mockedRaffle.getWinnerNumber()).thenReturn(1);
        parkingTruckTwo.calculateCost(
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("02/05/2019 09:01:01")
        );
        Assert.assertEquals(10000, parkingTruckTwo.getCost(), 0.0);
    }

}

    
    
    

