package co.measurer;

import co.common.Product;

public class Trigger  {
    private MeasurerTemplate measurerTemplate;

    public Trigger(MeasurerTemplate measurerTemplate) {
        this.measurerTemplate = measurerTemplate;
    }

    public MeasurerTemplate getMeasurerTemplate() {
        return measurerTemplate;
    }

    public void setMeasurerTemplate(MeasurerTemplate measurerTemplate) {
        this.measurerTemplate = measurerTemplate;
    }


    public void throwMeasure(Product product){
        measurerTemplate.measure(product);
    }
}
