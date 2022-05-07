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
    // 1. clase que represente al sistema  PublisherProduct.publish(product);
    // 2. BeerTrigger es un suscriptor    SubscriberProduct.subscribe(); deliverCallback deliverCallback = (consumerTag, delivery) -> { onMessage()
    // 3. cuando llegue un evento debe poner a medir   BeerMeasurer.mesure(Product product):Measurment este deberia tener un message
 public void newBeer(Product product) throws Exception {
     PublisherProduct.publish(product);
     SubscriberProduct.subscribe();
     throwMeasure();
 }
}
