package co.software.modeling.main;

import java.util.ArrayList;

public class ActuatorRemoveBand extends Actuator{

    public ActuatorRemoveBand() {
        this.key = "actuator-remove-band";
    }

    @Override
    public boolean takeAction(ArrayList<Sensor> sensors) {
        if (sensors.get(0) instanceof SensorSize ) System.out.println("size");
        return sensors.get(0).value >= sensors.get(0).expectedValue;
    }
}
