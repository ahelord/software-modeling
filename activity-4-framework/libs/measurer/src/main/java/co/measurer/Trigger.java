package co.measurer;

import co.common.Product;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Trigger  {
    private MeasurementItemTemplate measurementItemTemplate;

    public Trigger(MeasurementItemTemplate measurementItemTemplate) throws IOException, TimeoutException {
        this.measurementItemTemplate = measurementItemTemplate;
        this.subscribeProducts();
    }

    private void subscribeProducts() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String QUEUE_NAME = "measurement";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for measurment. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            onMessage(delivery);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }

    private void onMessage(Delivery message) {
       this.throwMeasure(transformToProduct(message));
    }

    private Product transformToProduct(Delivery message) {
        String productText = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println(" [x] Received measurement '" + productText + "'");
        String[] measurementTextSplit = productText.split(",");
        return new Product(Integer.parseInt(measurementTextSplit[0]),  measurementTextSplit[1]);
    }

    public MeasurementItemTemplate getMeasurerTemplate() {
        return measurementItemTemplate;
    }

    public void setMeasurerTemplate(MeasurementItemTemplate measurementItemTemplate) {
        this.measurementItemTemplate = measurementItemTemplate;
    }

    public void throwMeasure(Product product){
        measurementItemTemplate.measure(product);
    }
}
