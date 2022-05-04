package co.software.modeling.common;

import java.util.ArrayList;

public abstract class Actuator {
    protected ArrayList<Sensor> sensors;
    protected String key;

    public abstract boolean generateAction(Measurement measurement, Sensor sensor);
}
