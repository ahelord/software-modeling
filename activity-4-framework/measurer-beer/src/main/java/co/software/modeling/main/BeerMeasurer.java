package co.software.modeling.main;

import co.common.Measurement;
import co.common.Product;
import co.common.Sensor;
import co.common.Tag;
import co.software.modeling.framework.client.MeasurerTemplate;

import java.util.ArrayList;

public class BeerMeasurer extends MeasurerTemplate {
    // TODO init process for each product
    // TODO implement trigger

    @Override
    public MeasurerTemplate getDataFromSensors(Product beer) {
        SensorSize sensorSize = new SensorSize();
        ArrayList<Measurement> measurements = new ArrayList<>();

        // TODO recoger de la cola
        measurements.add(new Measurement(beer.getId(),230, beer.getName()));
        sensorSize.setMeasurements(measurements);

        ArrayList<Sensor> sensors = new ArrayList<>();
        sensors.add(sensorSize);
        this.setSensors(sensors);
        return this;
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
