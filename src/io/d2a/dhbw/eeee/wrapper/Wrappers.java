package io.d2a.dhbw.eeee.wrapper;

import io.d2a.dhbw.eeee.wrapper.wrappers.DoubleWrapper;
import io.d2a.dhbw.eeee.wrapper.wrappers.IntegerWrapper;
import io.d2a.dhbw.eeee.wrapper.wrappers.ScannerWrapper;
import io.d2a.dhbw.eeee.wrapper.wrappers.StringWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wrappers {

    public static final Map<Class<?>, ParameterWrapper<?>> WRAPPERS = new HashMap<>() {{
        put(String.class, new StringWrapper());
        put(Scanner.class, new ScannerWrapper());
    }};

    static {
        final IntegerWrapper integerWrapper = new IntegerWrapper();
        WRAPPERS.put(int.class, integerWrapper);
        WRAPPERS.put(Integer.class, integerWrapper);

        final DoubleWrapper doubleWrapper = new DoubleWrapper();
        WRAPPERS.put(double.class, doubleWrapper);
        WRAPPERS.put(Double.class, doubleWrapper);
    }

}
