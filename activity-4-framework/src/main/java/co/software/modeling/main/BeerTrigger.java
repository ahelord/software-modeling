package co.software.modeling.main;

import co.measurer.MeasurementItemTemplate;
import co.measurer.Trigger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class BeerTrigger extends Trigger {

    public BeerTrigger(MeasurementItemTemplate measurerTemplate) throws IOException, TimeoutException {
        super(measurerTemplate);
    }

}
