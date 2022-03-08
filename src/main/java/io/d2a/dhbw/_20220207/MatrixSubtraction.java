package io.d2a.dhbw._20220207;

import java.util.Scanner;

public class MatrixSubtraction {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = E.reqV(scanner, "n");
        final int m = E.reqV(scanner, "m");

        // create arrays and generate data
        final int[][] x = new int[n][m];
        final int[][] y = new int[n][m];

        System.out.println("X:");
        E.fillArray(x, 100);
        E.println(x);

        System.out.println("Y:");
        E.fillArray(y, 100);
        E.println(y);

        final int[][] xmy = new int[n][m];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                xmy[i][j] = x[i][j] - y[i][j];
            }
        }
        System.out.println("X-Y:");
        E.println(xmy);
    }

}
