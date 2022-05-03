package co.software.modeling.main;

import java.util.ArrayList;

public abstract class Sensor {
    protected String unitOfMeasurement;
    protected String key;
    protected double value;
    protected double expectedValue;

    public abstract ArrayList<Tag> assingTags();

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(double expectedValue) {
        this.expectedValue = expectedValue;
    }


/*    public abstract String getKey();

    public abstract double getValue();

    public abstract void setValue(double value);*/
}
