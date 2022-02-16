package io.d2a.dhbw._20220214.scratch;

import io.d2a.dhbw.eeee.annotations.AnnotationProvider;
import io.d2a.dhbw.eeee.annotations.Default;
import io.d2a.dhbw.eeee.annotations.parameters.Prompt;
import io.d2a.dhbw.eeee.annotations.parameters.number.Max;
import io.d2a.dhbw.eeee.annotations.parameters.number.Min;
import io.d2a.dhbw.eeee.generate.Factory;
import io.d2a.dhbw.eeee.wrapper.Wrapper;
import java.util.Scanner;

public class Rectangle implements Wrapper<Rectangle> {

    @Prompt("Hoehe")
    @Min(1)
    @Max(1000)
    @Default("256")
    private double height;

    @Prompt("Breite")
    @Min(1)
    @Max(1000)
    @Default("256")
    private double width;

    @Override
    public String toString() {
        return "Rectangle{" +
            "height=" + height +
            ", width=" + width +
            '}';
    }

    @Override
    public Rectangle wrap(final Scanner scanner, final String prompt,
        final AnnotationProvider provider) {
        try {
            return Factory.createClass(scanner, Rectangle.class);
        } catch (Exception e) {
            return null;
        }
    }
}
