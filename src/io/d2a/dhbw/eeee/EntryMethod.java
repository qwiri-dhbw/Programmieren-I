package io.d2a.dhbw.eeee;

import io.d2a.dhbw.eeee.annotations.Entrypoint;
import io.d2a.dhbw.eeee.annotations.parameters.Prompt;
import io.d2a.dhbw.eeee.inject.Injector;
import io.d2a.dhbw.eeee.wrapper.ParameterWrapper;
import io.d2a.dhbw.eeee.wrapper.Wrappers;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryMethod {

    public final Method method;
    public final Entrypoint entrypoint;
    public final Class<?> clazz;

    public EntryMethod(final Method method, final Entrypoint entrypoint, final Class<?> clazz) {
        this.method = method;
        this.entrypoint = entrypoint;
        this.clazz = clazz;
    }

    public void invoke(final Scanner scanner, final Injector injector) throws Exception {
        final String typeStr = Starter.formatTypes(method.getParameterTypes(), true);

        // get constructor
        final Constructor<?> constructor = this.clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        // create instance
        final Object instance = constructor.newInstance();

        // inject fields into instance
        injector.inject(instance);

        final List<Object> parameters = new ArrayList<>();

        // get parameters from method
        System.out.printf("[Runner] Requesting parameters (%s) ...%n", typeStr);

        // request parameters
        if (this.method.getParameterCount() > 0) {
            System.out.println();

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
        }
        System.out.println();

        // invoke method
        System.out.printf("[Runner] Invoking %s@%s w/ (%s)...%n---%n",
            method.getName(), clazz.getSimpleName(), typeStr);

        final long timeStart = System.currentTimeMillis();
        this.method.invoke(instance, parameters.toArray());
        final long timeEnd = System.currentTimeMillis();

        System.out.println("---");
        System.out.printf("Execution complete! Took approx. %dms.%n", timeEnd - timeStart);
    }

}
