package io.d2a.dhbw.eeee.wrapper;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.annotations.parameters.number.Max;
import io.d2a.dhbw.eeee.annotations.parameters.number.Min;
import io.d2a.dhbw.eeee.prompt.Prompt;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public abstract class DefaultRangeWrapper<T> implements ParameterWrapper<T> {

    public abstract T wrapValue(final String def);

    ///

    public boolean testRange(final T t, final Double min, final Double max) {
        return true;
    }

    public boolean testParameter(final T t, final Parameter parameter) {
        return true;
    }

    ///

    public abstract Prompt prompt();

    public String generatePrompt(
        final String prompt,
        final String type,
        final Double min,
        final Double max,
        final String def
    ) {
        return Annotations.generatePrompt(prompt, type, min, max, def);
    }

    @Override
    public T wrap(final Scanner scanner, final String prompt, final Parameter parameter) {
        final Double min = Annotations.get(Min.class, parameter);
        final Double max = Annotations.get(Max.class, parameter);
        final String def = Annotations.def(parameter);

        final String displayPrompt = this.prompt().prompt(parameter, prompt, def);

        while (true) {
            System.out.print(displayPrompt);
            final String input = scanner.nextLine().trim();

            // default value
            if (def != null && input.length() == 0) {
                // return default
                return this.wrapValue(def);
            }

            try {
                final T d = this.wrapValue(input);
                if (!this.testRange(d, min, max) || !this.testParameter(d, parameter)) {
                    continue;
                }
                return d;
            } catch (final Exception ignored) {

            }
        }
    }
}
