package io.d2a.dhbw.eeee.wrapper.wrappers;

import io.d2a.dhbw.eeee.wrapper.ParameterWrapper;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class ScannerWrapper implements ParameterWrapper<Scanner> {

    @Override
    public Scanner wrap(final Scanner scanner, final String prompt, final Parameter parameter) {
        return scanner;
    }

}
