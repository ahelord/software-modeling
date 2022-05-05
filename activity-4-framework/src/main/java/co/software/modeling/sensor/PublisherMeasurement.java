package co.software.modeling.sensor;

import co.software.modeling.common.Measurement;
import co.software.modeling.common.Product;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublisherMeasurement {
    private final static String QUEUE_NAME = "measurement";

    public static void publish(Measurement measurement) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String measurementText = measurement.getId()+","+measurement.getValue();
            channel.basicPublish("", QUEUE_NAME, null, measurementText.getBytes());
            System.out.println(" [x] publish measurementText: " + measurementText + "'");
        }
    }
}
