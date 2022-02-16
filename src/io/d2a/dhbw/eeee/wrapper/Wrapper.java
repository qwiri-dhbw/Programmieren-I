package io.d2a.dhbw.eeee.wrapper;

import io.d2a.dhbw.eeee.annotations.AnnotationProvider;
import java.util.Scanner;

public interface Wrapper<T> {

    T wrap(
        final Scanner scanner,
        final String prompt,
        final AnnotationProvider provider
    );

}
