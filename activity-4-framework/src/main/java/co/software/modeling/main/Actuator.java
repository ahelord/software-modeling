package co.software.modeling.main;

import java.util.ArrayList;

public abstract class Actuator {
    protected String key;
    public abstract boolean takeAction(ArrayList<Sensor> sensors);
}
