package co.software.modeling.main;

import co.sender.SenderProduct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, TimeoutException {
        // init
        long start = System.currentTimeMillis();
        long end = start + 5 * 1000;
        int index = 1;
        while (System.currentTimeMillis() < end) {
            System.out.println(System.currentTimeMillis());
            BeerTrigger beerTrigger = new BeerTrigger(new BeerMeasurerItem());
            SenderProduct.send(new Beer(index,"Club Colombia"));
            index++;
            Thread.sleep(1000);
            // Some expensive operation on the item.
        }
/*        System.out.println("running");
        BeerTrigger beerTrigger = new BeerTrigger(new BeerMeasurer());
        long start = System.currentTimeMillis();
        long end = start + 5 * 1000;
        int index = 1;
        while (System.currentTimeMillis() < end) {
            System.out.println(System.currentTimeMillis());
            beerTrigger.newBeer(new Beer(index,"Club Colombia"));
            index++;
            Thread.sleep(1000);
            // Some expensive operation on the item.
        }*/
/*        ItemMedicion medcerveza = miFabrica.crearItemMedicion();
        medcerveza.setSensor (new SensorCamara(new LecturaSimple()));
        medcerveza.setActuador (new BrazoEmpuje());*/

    }
}
