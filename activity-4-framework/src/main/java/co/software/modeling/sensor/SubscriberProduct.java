package co.software.modeling.sensor;

import co.software.modeling.common.Measurement;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class SubscriberProduct {
    private final static String QUEUE_NAME = "product";

    public static void subscribe() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String productText = new String(delivery.getBody(), StandardCharsets.UTF_8);

            System.out.println(" [x] Received '" + productText + "'");
            String[] productTextSplit = productText.split(",");
            Measurement measurement = new Measurement(Integer.parseInt(productTextSplit[0]), Math.random() * (500 - 150 + 1) + 150, productTextSplit[1]);
            try {
                PublisherMeasurement.publish(measurement);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}
