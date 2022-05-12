package co.common;

import java.util.ArrayList;

public abstract class Actuator {
    protected String key;

    public abstract boolean evalAction(Measurement measurement, Sensor sensor);
}
