package co.software.modeling.framework.client;

import co.software.modeling.common.Product;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Trigger  {
    private MeasurerTemplate measurerTemplate;

    public Trigger() {
        this.measurerTemplate = MeasurerFactory.getMeasurer();
    }

    public MeasurerTemplate getMeasurerTemplate() {
        return measurerTemplate;
    }

    public void setMeasurerTemplate(MeasurerTemplate measurerTemplate) {
        this.measurerTemplate = measurerTemplate;
    }


    public void throwMeasure() throws IOException, TimeoutException {

        measurerTemplate.measure();
    }
}
