package io.d2a.dhbw._20220207;

import java.util.Random;
import java.util.stream.IntStream;

public class StandardDeviation {

    public static void main(String[] args) {
        final Random random = new Random();
        final int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        final double mw = (1D / array.length) * IntStream.of(array).sum();;
        System.out.printf("Mittelwert: %f%n", mw);

        final double sa = Math.sqrt((1D / (array.length - 1)) *
                IntStream.of(array).mapToDouble(x -> Math.pow(x - mw, 2)).sum());
        System.out.printf("Std. Abw. %f%n", sa);
    }

}
