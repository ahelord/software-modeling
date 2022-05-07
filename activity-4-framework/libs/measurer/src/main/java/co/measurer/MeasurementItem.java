package co.measurer;

import co.common.Actuator;
import co.common.Measurement;
import co.common.Sensor;
import co.common.Tagger;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class MeasurementItem {
    private Sensor sensor;
    private Actuator actuator;
    private ArrayList<Measurement> measurements;

    private Tagger tagger;

    public ArrayList<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(ArrayList<Measurement> measurements) {
        this.measurements = measurements;
    }


    public MeasurementItem() throws IOException, TimeoutException {
        this.measurements = new ArrayList<>();
        this.subscribeMeasurement();
    }

    private void subscribeMeasurement() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String QUEUE_NAME = "measurement";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for measurment. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            try {
                onMessage(delivery);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }

    private void onMessage(Delivery message) throws IOException, TimeoutException {
        try{
            System.out.println(" [x] Received measurement text '" + new String(message.getBody(), StandardCharsets.UTF_8) + "'");
            receiveMeasurment(transformToMeasurement(message));
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private Measurement transformToMeasurement(Delivery message) {
        String measurementText = new String(message.getBody(), StandardCharsets.UTF_8);
        String[] measurementTextSplit = measurementText.split(",");
        return new Measurement(Integer.parseInt(measurementTextSplit[0]), Double.parseDouble(measurementTextSplit[1]),measurementTextSplit[2]);
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Actuator getActuator() {
        return actuator;
    }

    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

    public Tagger getTagger() {
        return tagger;
    }

    public void setTagger(Tagger tagger) {
        this.tagger = tagger;
    }

    public void receiveMeasurment(Measurement measurement) {
        measurement.setTakeAction(actuator.evalAction(measurement,sensor));
        measurement.setTag(tagger.evalTag(measurement));
        System.out.println("Take Action of ID: "+measurement.getId()+" action: "+ measurement.getTakeAction());
        System.out.println("Tag of Key: "+measurement.getTag().getKey()+" value: "+ measurement.getTag().getValue());
        measurements.add(measurement);
    }
}
