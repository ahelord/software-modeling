package co.measurer;

import co.common.Product;
//import co.software.modeling.main.BeerMeasurer;

public class MeasurerFactory {
    public static MeasurerTemplate getMeasurer(){
        return new MeasurerTemplate() {
            @Override
            public MeasurerTemplate getDataFromSensors(Product product) {
                return null;
            }

            @Override
            public MeasurerTemplate assignTags() {
                return null;
            }

            @Override
            public MeasurerTemplate triggerActuator() {
                return null;
            }
        };
        // TODO use properties implement below
       //return new BeerMeasurer() ;
    }
}
