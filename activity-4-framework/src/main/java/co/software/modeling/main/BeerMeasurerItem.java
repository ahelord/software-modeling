package co.software.modeling.main;

import co.common.Measurement;
import co.common.Product;
import co.common.Tag;
import co.measurer.MeasurementItemTemplate;

import java.util.ArrayList;

public class BeerMeasurerItem extends MeasurementItemTemplate {
    // TODO init process for each product
    // TODO implement trigger

    @Override
    public MeasurementItemTemplate getDataFromSensors(Product beer) {
        SensorSize sensorSize = new SensorSize();
        ArrayList<Measurement> measurements = new ArrayList<>();

        // TODO recoger de la cola
        measurements.add(new Measurement(beer.getId(),230, beer.getName()));
        sensorSize.setMeasurements(measurements);
        this.setSensor(sensorSize);
        return this;
    }

    @Override
    public MeasurementItemTemplate assignTags() {
            for (int j = 0; j < this.getSensor().measurements.size(); j++) {
                String tagValue;
                if (this.getSensor().measurements.get(j).getValue() > 230) {
                    tagValue = TagSizeType.OVER_WEIGHT.toString();
                } else {
                    tagValue = TagSizeType.NORMAL_WEIGHT.toString();
                }
                Tag tag = new Tag("weight", tagValue);
                this.getSensor().measurements.get(j).setTag(tag);
            }

        return this;
    }

    @Override
    public MeasurementItemTemplate triggerActuator() {
        ActuatorRemoveBand actuatorRemoveBand = new ActuatorRemoveBand();
            for (int j = 0; j < this.getSensor().measurements.size(); j++) {
                this.getSensor().measurements.get(j).setTakeAction(actuatorRemoveBand.evalAction(this.getSensor().measurements.get(j),this.getSensor()));
                System.out.println(this.getSensor().measurements.get(j).toString());
            }

        return this;
    }

}
