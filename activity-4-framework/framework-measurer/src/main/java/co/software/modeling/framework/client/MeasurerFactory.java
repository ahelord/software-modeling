package co.software.modeling.framework.client;

import co.software.modeling.main.BeerMeasurer;

public class MeasurerFactory {
    public static MeasurerTemplate getMeasurer(){
        // TODO use properties
       return new BeerMeasurer() ;
    }
}
