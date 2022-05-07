package co.software.modeling.main;

import co.common.Measurement;
import co.common.Tag;
import co.common.Tagger;

public class TaggerSize extends Tagger {
    @Override
    public Tag evalTag(Measurement measurement) {
        String tagValue;
        if (measurement.getValue() > 230) {
            tagValue = TagSizeType.OVER_WEIGHT.toString();
        } else {
            tagValue = TagSizeType.NORMAL_WEIGHT.toString();
        }
        return new Tag("weight", tagValue);
    }
}
