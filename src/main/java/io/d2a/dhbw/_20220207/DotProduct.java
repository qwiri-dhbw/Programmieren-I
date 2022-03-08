package io.d2a.dhbw._20220207;

import java.util.Scanner;

public class DotProduct {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        final int n = scanner.nextInt();
        final int[] arrayX = new int[n];
        final int[] arrayY = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Bitte x_%d eingeben: ", i);
            arrayX[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Bitte y_%d eingeben: ", i);
            arrayY[i] = scanner.nextInt();
        }

        int skalar = 0;
        for (int i = 0; i < n; i++) {
            skalar += arrayX[i] * arrayY[i];
        }

        System.out.printf("Skalar: %d%n", skalar);
    }

}
