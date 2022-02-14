package io.d2a.dhbw.eeee.wrapper;

import io.d2a.dhbw.eeee.annotations.Annotations;

public class DoubleWrapper extends MinMaxDefWrapper<Double> {

    @Override
    public Double wrapValue(final String def) {
        return Double.parseDouble(def);
    }

    @Override
    public boolean test(final Double val, final Double min, final Double max) {
        return Annotations.testRange(min, max, val);
    }

}
