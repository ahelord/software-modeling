package co.software.modeling.main;

import co.software.modeling.common.Product;
import co.software.modeling.framework.client.Trigger;
import co.software.modeling.sensor.PublisherMeasurement;
import co.software.modeling.sensor.PublisherProduct;
import co.software.modeling.sensor.SubscriberProduct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class BeerTrigger extends Trigger {

    // TODO evento desde rabbitmq
 public void newBeer(Product product) throws Exception {
     PublisherProduct.publish(product);
     SubscriberProduct.subscribe();
     throwMeasure();
 }
}