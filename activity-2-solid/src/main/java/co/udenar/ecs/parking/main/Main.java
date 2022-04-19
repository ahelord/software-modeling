package co.udenar.ecs.parking.main;

import co.udenar.ecs.parking.domain.Vehicle;
import co.udenar.ecs.parking.domain.VehicleCar;
import co.udenar.ecs.parking.domain.VehicleEnum;
import co.udenar.ecs.parking.domain.VehicleMotorcycle;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("running");
        
        Vehicle v = new VehicleMotorcycle(VehicleEnum.MOTORCYCLE, 3000, 3, 1000);
        
        System.out.println("PAGO MOTO: " + v.totalPago(3.5));
        
        
        Vehicle vC = new VehicleCar(VehicleEnum.CAR, 2000, 1, 2000);
        
        System.out.println("PAGO CARRO: " + vC.totalPago(3.5));
        
        test();
    }

    /**
     * test method
     */
    public static void test() {
        System.out.println("test method");
    }

    
}
