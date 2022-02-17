package io.d2a.dhbw._20220207;

import java.util.stream.IntStream;

public class Norm {

    public static void main(String[] args) {
        final int[] array = E.requestArray();
        final double bet = Math.sqrt(IntStream.of(array).map(i -> i * i).sum());
        System.out.printf("Der Betrag von x ist %f%n", bet);
    }

}
