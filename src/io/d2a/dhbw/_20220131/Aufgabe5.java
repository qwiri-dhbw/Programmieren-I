package io.d2a.dhbw._20220131;

import java.util.Scanner;

/*
 * Entwickeln Sie ein Programm AddUp, das beliebig viele positive Zahlen von der Konsole einliest
 * und diese Zahlen aufsummiert!
 *
 * Verwenden Sie als Abbruchkriterium die Eingabe einer negativen Zahl
 * (diese soll nicht mehr hinzugezählt werden).
 *
 * Am Ende soll die Summe aller eingegebenen positiven Zahlen ausgegeben werden.
 * Realisieren Sie AddUp einmal mit einer while-Schleife und einmal mit einer do-while-Schleife!
 */
public class Aufgabe5 {

    private interface Loopy {

        int loop(final Scanner scanner);

    }

    public static class WhileLoop implements Loopy {

        @Override
        public int loop(final Scanner scanner) {
            int res = 0;
            while (true) {
                System.out.print("Zahl 🥺👉👈 > ");
                final int num = scanner.nextInt();
                if (num < 0) {
                    break;
                }
                res += num;
            }
            return res;
        }

    }

    public static class DoWhileLoop implements Loopy {

        @Override
        public int loop(final Scanner scanner) {
            int res = 0;
            int num;
            do {
                System.out.print("Zahl 🥺👉👈 > ");
                num = scanner.nextInt();
                if (num < 0) {
                    break;
                }
                res += num;
            } while (num > 0);
            return res;
        }

    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Loopy loopy = new WhileLoop();

        // uncomment this to use doWhileLoop
        // loopy = new DoWhileLoop();

        System.out.println("\n🤯 " + loopy.loop(scanner));
    }
}