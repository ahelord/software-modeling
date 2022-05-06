package co.software.modeling.framework.measurer;

import co.common.Measurement;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublisherMeasure {
    private final static String QUEUE_NAME = "measure";

    public void publish(Measurement measurement) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, measurement.toString().getBytes());
            System.out.println(" [x] Sent '" + measurement + "'");
        }
    }
}
