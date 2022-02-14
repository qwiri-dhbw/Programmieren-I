package io.d2a.dhbw.eeee.wrapper;

import java.lang.reflect.Parameter;
import java.util.Scanner;

public interface ParameterWrapper<T> {

    T wrap(final Scanner scanner, final String prompt, final Parameter parameter);

}
