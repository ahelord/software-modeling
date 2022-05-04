package co.software.modeling.framework.measurer;

import co.software.modeling.common.Sensor;

import java.util.ArrayList;

public class MeasurerDirector {
    public MeasurerBuilder measurerBuilder;


    public void setBuilder(final MeasurerBuilder measurerBuilder) {
        this.measurerBuilder = measurerBuilder;
    }

    public void measure() {
        measurerBuilder.getDataFromSensors();
        measurerBuilder.assignTags();
        measurerBuilder.triggerActuator();
    }

    /*    public Dish getDish() {
            return this.dishBuilder.getDish();
        }*/
    public ArrayList<Sensor> getSensors() {
        return this.measurerBuilder.sensors;
    }
}
