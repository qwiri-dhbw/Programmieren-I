package io.d2a.dhbw._20220214.scratch;

import java.util.ArrayList;
import java.util.Arrays;

public class E {

    private int height;
    private int width;
    private ArrayList<String> str;

    public E(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.str = new ArrayList<>(Arrays.asList("AAA", "BBB"));
    }

    private E() {
    }

    @Override
    public String toString() {
        return "E{" +
            "height=" + height +
            ", width=" + width +
            ", str=" + str +
            '}';
    }
}
