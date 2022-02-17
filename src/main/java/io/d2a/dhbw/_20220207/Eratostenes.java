package io.d2a.dhbw._20220207;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Eratostenes {

    public static void main(String[] args) {
        final int n = 100;
        int[] sieve = IntStream.rangeClosed(2, n).toArray();

        int primesIndex = 0;
        int[] primes = new int[sieve.length];

        while (IntStream.of(sieve).sum() != 0) {
            final int min = IntStream.of(sieve).min().orElse(0);
            sieve = IntStream.of(sieve)
                .filter(i -> i != min && i % min != 0)
                .toArray();

            primes[primesIndex++] = min;
        }
        primes = IntStream.of(primes).filter(i -> i != 0).toArray();

        System.out.println("Sieve: " + Arrays.toString(sieve));
        System.out.println("Primes: " + Arrays.toString(primes));
    }

}
