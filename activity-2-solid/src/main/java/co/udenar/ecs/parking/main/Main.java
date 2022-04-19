package co.udenar.ecs.parking.main;

import co.udenar.ecs.parking.domain.Parking;
import co.udenar.ecs.parking.domain.ParkingCar;
import co.udenar.ecs.parking.domain.VehicleEnum;
import co.udenar.ecs.parking.domain.ParkingMotorcycle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("running");

        try {
            Parking parkingMotorcycle = new ParkingMotorcycle();
            /*pakingCarro = new ParkingCarro()
             * pakingCarro.calculateCost(12/12/12, 12/13/12)
             * */
            System.out.println("PAGO MOTO: " + parkingMotorcycle.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 14:31:01")
            ));

            System.out.println("PAGO MOTO: " + parkingMotorcycle.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 10:31:01")
            ));


            Parking parkingCar = new ParkingCar();

            System.out.println("PAGO CARRO: " + parkingCar.calculateCost(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:01:01"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2019 09:31:01"))
            );

            test();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    /**
     * test method
     */
    public static void test() {
        System.out.println("test method");
    }


}
