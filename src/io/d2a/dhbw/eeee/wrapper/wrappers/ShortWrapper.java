package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.wrapper.MinMaxDefWrapper;

public class ShortWrapper extends MinMaxDefWrapper<Short> {

    @Override
    public Short wrapValue(final String def) {
        return Short.parseShort(def);
    }

    @Override
    public boolean test(final Short val, final Double min, final Double max) {
        return Annotations.testRange(min, max, val);
    }

    @Override
    public String promptType() {
        return "short";
    }

}
