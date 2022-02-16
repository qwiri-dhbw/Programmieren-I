package io.d2a.dhbw.eeee.prompt;

import io.d2a.dhbw.eeee.annotations.AnnotationProvider;

public interface Prompt {

    String prompt(final AnnotationProvider provider, final String prompt, final String def);

}
