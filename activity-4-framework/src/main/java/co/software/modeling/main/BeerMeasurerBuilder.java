package co.software.modeling.main;

import java.util.ArrayList;

public class BeerMeasurerBuilder extends MeasurerBuilder {

    @Override
    public MeasurerBuilder getDataFromSensors() {
        SensorSize sensorSize = new SensorSize();
        sensorSize.setValue(200);
        ArrayList<Sensor> sensors = new ArrayList<>();
        sensors.add(sensorSize);
        this.setSensors(sensors);
        return this;
    }
}
