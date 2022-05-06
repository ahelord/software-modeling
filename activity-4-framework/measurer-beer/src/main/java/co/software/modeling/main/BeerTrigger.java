package co.software.modeling.main;

import co.common.Product;
import co.measurer.MeasurerTemplate;
import co.measurer.Trigger;

public class BeerTrigger extends Trigger {

    public BeerTrigger(MeasurerTemplate measurerTemplate) {
        super(measurerTemplate);
    }

    // TODO evento desde rabbitmq
 public void newBeer(Product product){
     throwMeasure(product);
 }
}
