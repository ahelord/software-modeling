package co.measurer;

import co.common.Actuator;
import co.common.Product;
import co.common.Sensor;

public abstract class MeasurementItemTemplate {
    private Sensor sensor;
    private Actuator actuator;

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

    public abstract MeasurementItemTemplate getDataFromSensors(Product product);

    public abstract MeasurementItemTemplate assignTags();

    public abstract MeasurementItemTemplate triggerActuator();
    public void measure(Product product) {
        getDataFromSensors(product);
        assignTags();
        triggerActuator();
    }
}
