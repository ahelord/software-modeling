package co.software.modeling.main;

import co.software.modeling.common.Measurement;
import co.software.modeling.common.Product;
import co.software.modeling.common.Sensor;
import co.software.modeling.common.Tag;
import co.software.modeling.framework.client.MeasurerTemplate;
import co.software.modeling.sensor.PublisherMeasurement;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class BeerMeasurer extends MeasurerTemplate {
    private final static String QUEUE_NAME = "measurement";

    @Override
    public void getDataFromSensors() throws IOException, TimeoutException {
        SensorSize sensorSize = new SensorSize();
        ArrayList<Measurement> measurements = new ArrayList<>();

        //
        ArrayList<Sensor> sensors = new ArrayList<>();


        // TODO recoger de la cola
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for measurment. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String measurementText = new String(delivery.getBody(), StandardCharsets.UTF_8);

            System.out.println(" [x] Received measurement '" + measurementText + "'");
            String[] measurementTextSplit = measurementText.split(",");
            Measurement measurement = new Measurement(Integer.parseInt(measurementTextSplit[0]), Math.random() * (500 - 150 + 1) + 150, measurementTextSplit[1]);
            measurements.add(measurement);
            // assign tags
            for (int i = 0; i < sensors.size(); i++) {
                for (int j = 0; j < sensors.get(i).measurements.size(); j++) {
                    String tagValue;
                    if (sensors.get(i).measurements.get(j).getValue() > 230) {
                        tagValue = TagSizeType.OVER_WEIGHT.toString();
                    } else {
                        tagValue = TagSizeType.NORMAL_WEIGHT.toString();
                    }
                    Tag tag = new Tag("weight", tagValue);
                    sensors.get(i).measurements.get(j).setTag(tag);
                }
            }

            // actuator
            ActuatorRemoveBand actuatorRemoveBand = new ActuatorRemoveBand();
            for (int i = 0; i < sensors.size(); i++) {
                for (int j = 0; j < sensors.get(i).measurements.size(); j++) {
                    sensors.get(i).measurements.get(j).setTakeAction(actuatorRemoveBand.evalAction(sensors.get(i).measurements.get(j), sensors.get(i)));
                    System.out.println(sensors.get(i).measurements.get(j).toString());
                }
            }
            sensorSize.setMeasurements(measurements);
            sensors.add(sensorSize);
            this.setSensors(sensors);


        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
        //measurements.add(new Measurement(beer.getId(),230, beer.getName()));
        //sensorSize.setMeasurements(measurements);

//        ArrayList<Sensor> sensors = new ArrayList<>();
//        sensors.add(sensorSize);
//        this.setSensors(sensors);
//        return this;
    }

    @Override
    public MeasurerTemplate assignTags() {
        for (int i = 0; i < sensors.size(); i++) {
            for (int j = 0; j < sensors.get(i).measurements.size(); j++) {
                String tagValue;
                if (sensors.get(i).measurements.get(j).getValue() > 230) {
                    tagValue = TagSizeType.OVER_WEIGHT.toString();
                } else {
                    tagValue = TagSizeType.NORMAL_WEIGHT.toString();
                }
                Tag tag = new Tag("weight", tagValue);
                sensors.get(i).measurements.get(j).setTag(tag);
            }
        }
        return this;
    }

    @Override
    public MeasurerTemplate triggerActuator() {
        ActuatorRemoveBand actuatorRemoveBand = new ActuatorRemoveBand();
        for (int i = 0; i < sensors.size(); i++) {
            for (int j = 0; j < sensors.get(i).measurements.size(); j++) {
                sensors.get(i).measurements.get(j).setTakeAction(actuatorRemoveBand.evalAction(sensors.get(i).measurements.get(j), sensors.get(i)));
                System.out.println(sensors.get(i).measurements.get(j).toString());
            }
        }
        return this;
    }

}
