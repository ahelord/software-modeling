package co.software.modeling.framework.measurer;

import co.software.modeling.common.Measurement;
import co.software.modeling.common.Sensor;

public class MeasurerFacade {
    static public void getMeasurements(MeasurerBuilder measurerBuilder) {
        MeasurerDirector director = new MeasurerDirector();
        director.setBuilder(measurerBuilder);
        director.measure();
        for (Sensor sensor : director.getSensors()) {
            System.out.println(sensor.toString());
            for (Measurement measurement : sensor.getMeasurements()) {
                System.out.println(measurement.toString());

            }
        }
    }
}
