package co.software.modeling.main;

import java.util.ArrayList;

public abstract class MeasurerBuilder {
    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    protected ArrayList<Sensor> sensors;


    public abstract MeasurerBuilder getDataFromSensors();
    //public abstract MeasurerBuilder getActuactors();
/*

    public abstract DishBuilder init();

    public abstract DishBuilder setName(String name);

    public abstract DishBuilder setPathOfMultimedia(String pathOfMultimedia);

    public abstract DishBuilder setCore();

    public abstract boolean addPart();

    public abstract DishBuilder setSize(Size sise);*/
}
