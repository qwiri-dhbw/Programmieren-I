package io.d2a.dhbw._20220207;

import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pascal {

    // stolen from:
    // https://stackoverflow.com/questions/45966883/code-for-finding-binomial-coefficient-in-iterative-form
    public static int binom(int n, int k) {
        int value = 1;
        for (int i = 0; i < k; i++) {
            value = (value * (n - i)) / (i + 1);
        }
        return value;
    }

    public static void main(String[] args) {
        final int n = 9;
        final int[][] pascal = new int[n][];
        for (int i = 0; i < n; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = binom(i, j);
            }
        }
        E.println(pascal);
        System.out.println();
        pascalPrint(pascal);
    }

    public static void pascalPrint(final int[][] array) {
        for (int i = 0; i < array.length; i++) {
            final String numbers = IntStream.of(array[i])
                .mapToObj(v -> String.format("%02d", v))
                .collect(Collectors.joining("   "));

            final int padding = (int) ((array.length - (i + 1)) * 2.5);

            final StringBuilder bob = new StringBuilder();
            for(int c = 0; c < padding; c ++, bob.append(" "));

            System.out.printf("%s%s%n", bob, numbers);
        }
    }

}
