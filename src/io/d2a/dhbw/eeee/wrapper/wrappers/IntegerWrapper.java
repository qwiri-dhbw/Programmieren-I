package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.wrapper.MinMaxDefWrapper;

public class IntegerWrapper extends MinMaxDefWrapper<Integer> {

    @Override
    public Integer wrapValue(final String def) {
        return Integer.parseInt(def);
    }

    @Override
    public boolean test(final Integer integer, final Double min, final Double max) {
        return Annotations.testRange(min, max, integer);
    }

    @Override
    public String promptType() {
        return "int";
    }

    @Override
    public String generatePrompt(
        final String prompt,
        final String type,
        final Double min,
        final Double max,
        final String def
    ) {
        final String range = range(min, max);
        final StringBuilder bob = new StringBuilder();
        bob.append("[").append(type).append("] ");
        if (range.length() > 2) {
            bob.append(range).append(' ');
        }
        bob.append(prompt);
        if (def != null) {
            bob.append(" [").append(def).append("]");
        }
        return bob.append(": ").toString();
    }

    public static String range(final Double min, final Double max) {
        if (min == null && max == null) {
            return "";
        }
        final StringBuilder bob = new StringBuilder();
        bob.append("[");
        if (min != null) {
            bob.append(min.intValue());
        }
        bob.append('-');
        if (max != null) {
            bob.append(max.intValue());
        }
        bob.append("]");
        return bob.toString();
    }

}
