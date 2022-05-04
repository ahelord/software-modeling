package co.software.modeling.main;

import co.software.modeling.framework.measurer.MeasurerFacade;

public class Main {
    public static void main(String[] args) {
        System.out.println("running");
        MeasurerFacade.getMeasurements(new BeerMeasurerBuilder());
    }
}
