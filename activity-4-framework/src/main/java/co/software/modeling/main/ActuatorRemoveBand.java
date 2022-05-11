package co.software.modeling.main;

import co.common.Actuator;
import co.common.Measurement;
import co.common.Sensor;

public class ActuatorRemoveBand extends Actuator {
    public ActuatorRemoveBand() {
        this.key = "actuator-remove-band";
    }

    public boolean evalAction(Measurement measurement, Sensor sensor) {
        return measurement.getValue() >= sensor.getExpectedValue();
    }
}
