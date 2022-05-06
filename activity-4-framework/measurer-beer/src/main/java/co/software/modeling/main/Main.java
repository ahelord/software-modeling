package co.software.modeling.main;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("running");
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
        }

    }
}
