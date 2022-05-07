package co.software.modeling.main;

import co.common.Measurement;
import co.measurer.MeasurementItem;
import co.trigger.Trigger;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, TimeoutException {
        String[] countryCodes = Locale.getISOCountries();

        MeasurementItem measurementItem = new MeasurementItem();
        measurementItem.setSensor(new SensorSize());
        measurementItem.setActuator(new ActuatorRemoveBand());
        measurementItem.setTagger(new TaggerSize());

        long start = System.currentTimeMillis();
        long end = start + 5 * 1000;
        int index = 1;
        while (System.currentTimeMillis() < end) {
            for (Measurement measurement : measurementItem.getMeasurements()) {
                System.out.println(" ID: " + measurement.getId() + ", value: " + measurement.getValue() + " ,name: " + measurement.getNameOfProduct()
                        + " ,take action: " + measurement.getTakeAction() + ", tag: " + measurement.getTag().getKey() + ", tag value: " + measurement.getTag().getValue());
            }
            Locale locale = new Locale("", countryCodes[index]);
            System.out.println(System.currentTimeMillis());
            Trigger.publish(new Beer(index, "Beer of " + locale.getDisplayCountry()));
            index++;
            Thread.sleep(1000);
        }
    }
}
