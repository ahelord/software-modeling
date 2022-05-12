package co.trigger;

import co.common.Product;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Trigger {
    private final static String QUEUE_NAME = "measurement";

    public static void publish(Product product) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for(int i =0; i<5; i++){
                String measurementText = String.valueOf(product.getId())+","+String.valueOf(Math.random() * (500 - 150 + 1) + 150)+","+product.getName();
                channel.basicPublish("", QUEUE_NAME, null, measurementText.getBytes());
                System.out.println(" [x] Sent ' measurementText: id: " + String.valueOf(product.getId()) + ", value: "+String.valueOf(Math.random() * (500 - 150 + 1) + 150)+ " , name:"+ product.getName());
            }
        }
    }
}
