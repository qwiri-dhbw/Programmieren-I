package io.d2a.dhbw._20220207;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 */
public class E {

    private static final Random random = new Random();

    public static int reqV(final Scanner scanner, final String x) {
        System.out.print("Bitte Anzahl der Elemente " + x + " eingeben: ");
        return scanner.nextInt();
    }

    public static int[] requestArray() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        final int n = scanner.nextInt();
        final int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Bitte x_%d eingeben: ", i);
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] generateArray(final int n, final int bounds) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = random.nextInt(bounds);
        }
        return res;
    }

    public static void fillArray(final int[] array, final int bounds) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bounds);
        }
    }

    public static void fillArray(final int[][] array, final int bounds) {
        for (final int[] ints : array) {
            fillArray(ints, bounds);
        }
    }

    public static void println(final int[][] array) {
        for (final int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
