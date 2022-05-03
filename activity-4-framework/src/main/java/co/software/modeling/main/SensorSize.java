package co.software.modeling.main;

import java.util.ArrayList;

public class SensorSize extends Sensor {


    public SensorSize() {
        this.key = "size";
        this.unitOfMeasurement = "ml";
        this.expectedValue = 230;
    }

    @Override
    public ArrayList<Tag> assingTags() {
        ArrayList<Tag> tags = new ArrayList<>();
        String value;
        if (getValue() > 230) {
            value = TagSizeType.OVER_WEIGHT.toString();
        } else {
            value = TagSizeType.NORMAL_WEIGHT.toString();
        }
        Tag tag = new Tag("weight", value);
        tags.add(tag);
        return tags;
    }

/*    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public void setValue(double value) {

    }*/
}
