package co.software.modeling.main;

import co.common.Product;
import co.measurer.Trigger;

public class BeerTrigger extends Trigger {

    // TODO evento desde rabbitmq
 public void newBeer(Product product){
     throwMeasure(product);
 }
}
