package co.software.modeling.main;

import co.software.modeling.common.Product;
import co.software.modeling.framework.client.Trigger;

public class BeerTrigger extends Trigger {

    // TODO evento desde rabbitmq
 public void newBeer(Product product){
     throwMeasure(product);
 }
}
