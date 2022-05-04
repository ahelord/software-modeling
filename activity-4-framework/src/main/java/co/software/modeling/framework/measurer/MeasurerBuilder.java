package co.software.modeling.framework.measurer;

import co.software.modeling.common.Actuator;
import co.software.modeling.common.Sensor;

import java.util.ArrayList;

public abstract class MeasurerBuilder {
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


    public abstract MeasurerBuilder getDataFromSensors();

    public abstract MeasurerBuilder assignTags();

    public abstract MeasurerBuilder triggerActuator();
    //public abstract MeasurerBuilder getActuactors();
/*

    public abstract DishBuilder init();

    public abstract DishBuilder setName(String name);

    public abstract DishBuilder setPathOfMultimedia(String pathOfMultimedia);

    public abstract DishBuilder setCore();

    public abstract boolean addPart();

    public abstract DishBuilder setSize(Size sise);*/
}
