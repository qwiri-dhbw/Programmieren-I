package io.d2a.dhbw._20220214.scratch;

import io.d2a.dhbw.eeee.annotations.Default;
import io.d2a.dhbw.eeee.annotations.parameters.Prompt;
import io.d2a.dhbw.eeee.annotations.parameters.number.Max;
import io.d2a.dhbw.eeee.annotations.parameters.number.Min;
import io.d2a.dhbw.eeee.inject.Inject;
import java.util.Arrays;

public class Rectangle {

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

    @Inject
    private String[] args;

    @Override
    public String toString() {
        return "Rectangle{" +
            "height=" + height +
            ", width=" + width +
            ", args=" + Arrays.toString(args) +
            '}';
    }
}
