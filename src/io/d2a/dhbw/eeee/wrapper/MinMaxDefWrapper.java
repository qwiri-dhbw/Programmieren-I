package io.d2a.dhbw.eeee.wrapper;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.annotations.parameters.number.Max;
import io.d2a.dhbw.eeee.annotations.parameters.number.Min;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public abstract class MinMaxDefWrapper<T> implements ParameterWrapper<T> {

    public abstract T wrapValue(final String def);

    public abstract boolean test(T t, Double min, Double max);

    public abstract String promptType();

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
        final String displayPrompt = this.generatePrompt(prompt, this.promptType(), min, max, def);

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
                if (!this.test(d, min, max)) {
                    continue;
                }
                return d;
            } catch (final Exception ignored) {

            }
        }
    }
}
