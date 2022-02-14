package io.d2a.dhbw._20220207;

import java.util.stream.IntStream;

public class StandardDeviation {

    public static void main(String[] args) {
        final int[] array = new int[100];
        E.fillArray(array, 100);

        final double mw = (1D / array.length) * IntStream.of(array).sum();
        System.out.printf("Mittelwert: %f%n", mw);

        final double sa = Math.sqrt((1D / (array.length - 1)) *
                IntStream.of(array).mapToDouble(x -> Math.pow(x - mw, 2)).sum());
        System.out.printf("Std. Abw. %f%n", sa);
    }

}
