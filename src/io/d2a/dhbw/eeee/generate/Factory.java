package io.d2a.dhbw.eeee.generate;

import io.d2a.dhbw.eeee.EntryMethod;
import io.d2a.dhbw.eeee.annotations.parameters.Prompt;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Factory {

    public static <T> T createClass(final Scanner scanner, final Class<T> clazz) throws Exception {
        // create class
        final Constructor<T> constructor = clazz.getDeclaredConstructor();
        final T t = constructor.newInstance();

        // get all prompt values and request
        for (final Field field : clazz.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Prompt.class)) {
                continue;
            }
            field.setAccessible(true);
            final String prompt;
            if (field.isAnnotationPresent(Prompt.class)) {
                prompt = field.getAnnotation(Prompt.class).value();
            } else {
                prompt = field.getName();
            }

            // request value
            final Object object = EntryMethod.promptValue(
                scanner,
                field.getType(),
                prompt,
                field::getAnnotation
            );

            field.set(t, object);
        }

        return t;
    }

}
