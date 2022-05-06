package co.measurer;

import co.common.Actuator;
import co.common.Product;
import co.common.Sensor;

import java.util.ArrayList;

public abstract class MeasurerTemplate {
    protected ArrayList<Sensor> sensors;
    protected ArrayList<Actuator> actuators;

    public void setActuators(ArrayList<Actuator> actuators) {
        this.actuators = actuators;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    public abstract MeasurerTemplate getDataFromSensors(Product product);

    public abstract MeasurerTemplate assignTags();

    public abstract MeasurerTemplate triggerActuator();

    public void measure(Product product) {
        getDataFromSensors(product);
        assignTags();
        triggerActuator();
    }

}
