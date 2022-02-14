package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.wrapper.MinMaxDefWrapper;

public class StringWrapper extends MinMaxDefWrapper<String> {

    @Override
    public String wrapValue(final String def) {
        return def;
    }

    @Override
    public boolean test(final String s, final Double min, final Double max) {
        return Annotations.testRange(min, max, s.length());
    }

    @Override
    public String promptType() {
        return "string";
    }

}
