package io.d2a.dhbw._20220207;

import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(genFib(25)));
        System.out.println(Arrays.toString(genFib(50)));
        System.out.println(Arrays.toString(genBigFib(25)));
        System.out.println(Arrays.toString(genBigFib(50)));
        System.out.println(Arrays.toString(genBigFib(5000)));
    }


    private static int[] genFib(final int n) {
        final int[] res = new int[n];
        res[0] = res[1] = 1;

        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res;
    }

    private static BigInteger[] genBigFib(final int n) {
        final BigInteger[] res = new BigInteger[n];
        res[0] = res[1] = new BigInteger("1");

        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1].add(res[i - 2]);
        }

        return res;
    }

}
