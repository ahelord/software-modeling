package co.software.modeling.main;

import co.software.modeling.common.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("running");
        BeerTrigger beerTrigger = new BeerTrigger();
        long start = System.currentTimeMillis();
        long end = start + 5 * 1000;
        int index = 1;
        while (System.currentTimeMillis() < end) {
            System.out.println(System.currentTimeMillis());
            beerTrigger.newBeer(new Beer(index,"Club Colombia"));
            index++;
            Thread.sleep(1000);
            // Some expensive operation on the item.
        }

    }
}
