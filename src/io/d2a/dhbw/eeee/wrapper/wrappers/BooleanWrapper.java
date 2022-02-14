package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.wrapper.MinMaxDefWrapper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanWrapper extends MinMaxDefWrapper<Boolean> {

    private static final Set<String> YES = new HashSet<>(Arrays.asList(
        "true",
        "yes",
        "1",
        "ja"
    ));

    @Override
    public Boolean wrapValue(final String def) {
        return YES.contains(def.toLowerCase().trim());
    }

    @Override
    public boolean test(final Boolean aBoolean, final Double min, final Double max) {
        return true;
    }

    @Override
    public String promptType() {
        return "bool";
    }

}
