package co.software.modeling.main;

import co.software.modeling.common.Measurement;
import co.software.modeling.common.Sensor;
import co.software.modeling.common.Tag;
import co.software.modeling.framework.measurer.MeasurerBuilder;

import java.util.ArrayList;

public class BeerMeasurerBuilder extends MeasurerBuilder {
    private final ArrayList<Beer> beers = new ArrayList<>() {
        {
            add(new Beer(1, 220.0, "Club Colombia"));
            add(new Beer(2, 220.0, "Tecate"));
            add(new Beer(3, 250, "Aguila"));

        }
    };

    @Override
    public MeasurerBuilder getDataFromSensors() {
        SensorSize sensorSize = new SensorSize();
        ArrayList<Measurement> measurements = new ArrayList<>();

        for (Beer beer : beers) {
            measurements.add(new Measurement(beer.getId(), beer.getMilliliters(), beer.getName()));
        }
        sensorSize.setMeasurements(measurements);

        ArrayList<Sensor> sensors = new ArrayList<>();
        sensors.add(sensorSize);
        this.setSensors(sensors);
        return this;
    }

    @Override
    public MeasurerBuilder assignTags() {
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
    public MeasurerBuilder triggerActuator() {
        ActuatorRemoveBand actuatorRemoveBand = new ActuatorRemoveBand();
        for (int i = 0; i < sensors.size(); i++) {
            for (int j = 0; j < sensors.get(i).measurements.size(); j++) {
                sensors.get(i).measurements.get(j).setTakeAction(actuatorRemoveBand.generateAction(sensors.get(i).measurements.get(j), sensors.get(i)));
            }
        }
        return this;
    }

}
