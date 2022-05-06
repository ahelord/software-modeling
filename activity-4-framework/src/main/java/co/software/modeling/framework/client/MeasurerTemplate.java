package co.software.modeling.framework.client;

import co.software.modeling.common.Actuator;
import co.software.modeling.common.Product;
import co.software.modeling.common.Sensor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

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

    public abstract void getDataFromSensors() throws IOException, TimeoutException;

    public abstract MeasurerTemplate assignTags();

    public abstract MeasurerTemplate triggerActuator();

    public void measure() throws IOException, TimeoutException {
        // TODO make execution sync
            getDataFromSensors();
            //assignTags();
            //triggerActuator();
    }

}
