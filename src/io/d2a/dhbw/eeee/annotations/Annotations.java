package io.d2a.dhbw.eeee.annotations;

import io.d2a.dhbw.eeee.annotations.number.Max;
import io.d2a.dhbw.eeee.annotations.number.Min;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

public class Annotations {

    public static Double get(final Class<? extends Annotation> clazz, final Parameter parameter) {
        if (parameter.isAnnotationPresent(clazz)) {
            if (clazz.equals(Min.class)) {
                return parameter.getAnnotation(Min.class).value();
            } else if (clazz.equals(Max.class)) {
                return parameter.getAnnotation(Max.class).value();
            }
        }
        return null;
    }

    public static String range(final Double min, final Double max) {
        final StringBuilder bob = new StringBuilder();
        bob.append("[");
        if (min != null) {
            bob.append(min);
        }
        bob.append('-');
        if (max != null) {
            bob.append(max);
        }
        bob.append("]");
        return bob.toString();
    }

    public static boolean testRange(final Double min, final Double max, final double input) {
        if (min != null && input < min) {
            return false;
        }
        return max == null || !(input > max);
    }

    public static String generatePrompt(
        final String prompt,
        final String type,
        final Double min,
        final Double max,
        final String def
    ) {
        final String range = Annotations.range(min, max);
        final StringBuilder bob = new StringBuilder();
        bob.append("[").append(type).append("] ");
        if (range.length() > 2) {
            bob.append(range).append(' ');
        }
        bob.append(prompt);
        if (def != null) {
            bob.append(" [").append(def).append("]");
        }
        return bob.append(": ").toString();
    }

    public static String def(final Parameter parameter) {
        if (parameter.isAnnotationPresent(Default.class)) {
            return parameter.getAnnotation(Default.class).value();
        }
        return null;
    }

}
