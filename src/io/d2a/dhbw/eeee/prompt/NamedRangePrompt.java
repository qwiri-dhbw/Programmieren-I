package io.d2a.dhbw.eeee.prompt;

import io.d2a.dhbw.eeee.annotations.Annotations;
import io.d2a.dhbw.eeee.annotations.parameters.number.Max;
import io.d2a.dhbw.eeee.annotations.parameters.number.Min;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NamedRangePrompt implements Prompt {

    public static final String DEFAULT_FORMAT = "[%type%] [%range%] %prompt% [%default%]: ";

    private final String format;
    private final Map<String, Supplier> map;

    private NamedRangePrompt(
        final String format
    ) {
        this.format = format;
        this.map = new HashMap<>();
    }

    @Override
    public String prompt(final Parameter parameter, final String prompt, final String def) {
        this.map.put("prompt", p -> prompt);
        this.map.put("default", p -> def);

        String display = this.format;
        for (final Entry<String, Supplier> entry : this.map.entrySet()) {
            display = display.replace(
                "%" + entry.getKey() + "%",
                entry.getValue().replace(parameter)
            );
        }
        return display;
    }

    ///

    public interface Supplier {

        String replace(final Parameter parameter);

    }

    public NamedRangePrompt replace(final String key, final Supplier supplier) {
        this.map.put(key, supplier);
        return this;
    }

    ///

    public static NamedRangePrompt of(final String name, final String format) {
        return new NamedRangePrompt(format)
            .replace("type", p -> name)
            .replace("range", p -> {
                final Double min = Annotations.get(Min.class, p);
                final Double max = Annotations.get(Max.class, p);
                return Annotations.range(min, max);
            });
    }

    public static NamedRangePrompt of(final String name) {
        return of(name, DEFAULT_FORMAT);
    }

}
