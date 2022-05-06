package co.common;

import co.common.Measurement;
import co.common.Sensor;

import java.util.ArrayList;

public abstract class Actuator {
    protected ArrayList<Sensor> sensors;
    protected String key;

    public abstract boolean evalAction(Measurement measurement, Sensor sensor);
}
