package co.software.modeling.main;

import co.software.modeling.common.Actuator;
import co.software.modeling.common.Measurement;
import co.software.modeling.common.Sensor;

public class ActuatorRemoveBand extends Actuator {
    public ActuatorRemoveBand() {
        this.key = "actuator-remove-band";
    }

    public boolean generateAction(Measurement measurement, Sensor sensor) {
        // TODO  measurement.getValue() replace to subscription that await events
        return measurement.getValue() >= sensor.getExpectedValue();
    }
}
