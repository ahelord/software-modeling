package co.udenar.ecs.parking.main;

import co.udenar.ecs.parking.domain.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("running");

        try {

            Parking parkingMotorcycleOne = new ParkingMotorcycle();
            parkingMotorcycleOne.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 14:31:01"));
            Parking parkingMotorcycleTwo = new ParkingMotorcycle();
            parkingMotorcycleTwo.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:31:01")
            );

            Parking parkingCarOne = new ParkingCar();
            parkingCarOne.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 11:31:01")
            );
            Raffle raffle = new Raffle();

            Parking parkingTruckOne = new ParkingTruck(raffle, 1);
            parkingTruckOne.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("03/05/2019 09:01:01")
            );
            Parking parkingTruckTwo = new ParkingTruck(raffle, 30);
            parkingTruckTwo.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("03/05/2019 09:01:01")
            );
            Parking[] parkings = {
                    parkingMotorcycleOne,
                    parkingMotorcycleTwo,
                    parkingCarOne,
                    parkingTruckOne,
                    parkingTruckTwo
            };

            for (Parking parking : parkings) {
                System.out.println(parking.getClass().getSimpleName());
                System.out.println(parking.getCost());
            }

        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }


}
