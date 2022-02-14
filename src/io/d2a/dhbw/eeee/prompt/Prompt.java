package io.d2a.dhbw.eeee.prompt;

import java.lang.reflect.Parameter;

public interface Prompt {

    String prompt(final Parameter parameter, final String prompt, final String def);

}
