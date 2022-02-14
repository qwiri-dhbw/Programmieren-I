package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.prompt.NamedRangePrompt;
import io.d2a.dhbw.eeee.prompt.Prompt;
import io.d2a.dhbw.eeee.wrapper.DefaultRangeWrapper;

public class ShortWrapper extends DefaultRangeWrapper<Short> {

    @Override
    public Short wrapValue(final String def) {
        return Short.parseShort(def);
    }

    @Override
    public boolean testRange(final Short val, final Double min, final Double max) {
        return Annotations.testRange(min, max, val);
    }

    @Override
    public Prompt prompt() {
        return NamedRangePrompt.of("short");
    }

}
