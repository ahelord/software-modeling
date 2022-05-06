package co.common;

import java.util.ArrayList;

public abstract class Sensor {

    public ArrayList<Measurement> measurements;
    public String unitOfMeasurement;
    public String key;
    public double expectedValue;

    public ArrayList<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(ArrayList<Measurement> measurements) {
        this.measurements = measurements;
    }

    void addMeasurement(Measurement measurement) {
        getMeasurements().add(measurement);
    }


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

    public double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(double expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public String toString() {
        return "Sensor { key= " + key + ",  unit of Measurement= " + unitOfMeasurement + ", expected value= " + expectedValue + "}";
    }
}

