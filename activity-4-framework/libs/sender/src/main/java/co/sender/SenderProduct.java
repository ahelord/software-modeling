package co.sender;

import co.common.Product;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SenderProduct {
    private final static String QUEUE_NAME = "measurement";

    public static void send(Product product) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String productText = String.valueOf(product.getId())+","+product.getName();
            channel.basicPublish("", QUEUE_NAME, null, productText.getBytes());
            System.out.println(" [x] Sent ' productText: " + productText + "'");
        }
    }
}
