package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.prompt.NamedRangePrompt;
import io.d2a.dhbw.eeee.prompt.Prompt;
import io.d2a.dhbw.eeee.wrapper.DefaultRangeWrapper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanWrapper extends DefaultRangeWrapper<Boolean> {

    private static final Set<String> YES = new HashSet<>(Arrays.asList(
        "true",
        "yes",
        "1",
        "ja",
        "jo"
    ));

    @Override
    public Boolean wrapValue(final String def) {
        return YES.contains(def.toLowerCase().trim());
    }

    @Override
    public Prompt prompt() {
        return NamedRangePrompt.of("bool");
    }

}
