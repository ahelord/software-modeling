package co.software.modeling.main;

import co.software.modeling.common.Sensor;
import co.software.modeling.common.Tag;

public class SensorSize extends Sensor {

    public SensorSize() {
        this.key = "size";
        this.unitOfMeasurement = "ml";
        this.expectedValue = 230;
    }
}

