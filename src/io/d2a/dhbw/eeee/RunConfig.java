package io.d2a.dhbw.eeee;

import io.d2a.dhbw.eeee.annotations.Entrypoint;
import io.d2a.dhbw.eeee.annotations.parameters.Prompt;
import io.d2a.dhbw.eeee.wrapper.ParameterWrapper;
import io.d2a.dhbw.eeee.wrapper.Wrappers;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunConfig {

    final Method method;
    final Entrypoint entrypoint;
    final Class<?> clazz;

    public RunConfig(final Method method, final Entrypoint entrypoint, final Class<?> clazz) {
        this.method = method;
        this.entrypoint = entrypoint;
        this.clazz = clazz;
    }

    public void invoke(final Scanner scanner) throws Exception {
        // get constructor
        final Constructor<?> constructor = this.clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        // create instance
        final Object instance = constructor.newInstance();

        final List<Object> parameters = new ArrayList<>();

        // get parameters from method
        for (final Parameter parameter : this.method.getParameters()) {

            final ParameterWrapper<?> wrapper;
            if (ParameterWrapper.class.isAssignableFrom(parameter.getType())) {
                // get constructor
                final Constructor<?> wrapperConstructor = parameter.getType()
                    .getDeclaredConstructor();
                wrapperConstructor.setAccessible(true);
                wrapper = (ParameterWrapper<?>) wrapperConstructor.newInstance();
            } else {
                wrapper = Wrappers.WRAPPERS.get(parameter.getType());
            }

            // check if a wrapper is present for the paramter type
            if (wrapper == null) {
                System.out.printf("ERROR: cannot find wrapper for parameter type %s!%n",
                    parameter.getType().getSimpleName());
                return;
            }

            final String prompt;
            if (parameter.isAnnotationPresent(Prompt.class)) {
                prompt = parameter.getAnnotation(Prompt.class).value();
            } else {
                prompt = parameter.getName();
            }

            // execute wrapper
            parameters.add(wrapper.wrap(scanner, prompt, parameter));
        }

        // invoke method
        this.method.invoke(instance, parameters.toArray());
    }

}
