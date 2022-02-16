package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.annotations.AnnotationProvider;
import io.d2a.dhbw.eeee.wrapper.Wrapper;
import java.util.Scanner;

public class ScannerWrapper implements Wrapper<Scanner> {

    @Override
    public Scanner wrap(
        final Scanner scanner,
        final String prompt,
        final AnnotationProvider provider
    ) {
        return scanner;
    }

}
