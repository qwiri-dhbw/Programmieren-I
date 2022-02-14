package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.wrapper.MinMaxDefWrapper;

public class DoubleWrapper extends MinMaxDefWrapper<Double> {

    @Override
    public Double wrapValue(final String def) {
        return Double.parseDouble(def);
    }

    @Override
    public boolean test(final Double val, final Double min, final Double max) {
        return Annotations.testRange(min, max, val);
    }

    @Override
    public String promptType() {
        return "double";
    }

}
