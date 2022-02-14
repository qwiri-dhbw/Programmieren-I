package io.d2a.dhbw.eeee.wrapper;

import io.d2a.dhbw.eeee.annotations.Annotations;

public class IntegerWrapper extends MinMaxDefWrapper<Integer> {

    @Override
    public Integer wrapValue(final String def) {
        return Integer.parseInt(def);
    }

    @Override
    public boolean test(final Integer integer, final Double min, final Double max) {
        return Annotations.testRange(min, max, integer);
    }

}
