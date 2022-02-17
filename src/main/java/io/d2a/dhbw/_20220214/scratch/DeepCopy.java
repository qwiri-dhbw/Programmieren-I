package io.d2a.dhbw._20220214.scratch;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DeepCopy {

    public static <T> T deepCopy(final T in, final Class<T> clazz) throws Exception {
        // check if in is cloneable
        if (Cloneable.class.isAssignableFrom(clazz)) {
            System.out.printf("cloning using Clonable interface (Object.clone)%n");
            final Method clone = clazz.getDeclaredMethod("clone");
            clone.setAccessible(true);
            return (T) clone.invoke(in);
        }

        final Constructor<T> constructor;
        try {
            constructor = clazz.getDeclaredConstructor();
        } catch (final NoSuchMethodException nsme) {
            System.out.printf(" -- cannot find default constructor for class %s%n",
                clazz.getSimpleName());
            return in;
        }

        constructor.setAccessible(true);
        final T res = constructor.newInstance();
        for (final Field field : clazz.getDeclaredFields()) {
            // check if modifier contains final
            if (Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            System.out.printf("copying field %s from class %s%n",
                field.getName(), clazz.getSimpleName());

            field.setAccessible(true);

            final Object fieldVal = field.get(in);
            final Class<?> fieldType = field.getType();
            final Object newVal = deepCopy(fieldVal, (Class<? super Object>) fieldType);

            field.set(res, newVal);
        }
        return res;
    }

}
