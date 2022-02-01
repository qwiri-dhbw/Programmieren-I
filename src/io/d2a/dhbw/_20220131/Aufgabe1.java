package io.d2a.dhbw._20220131;

import java.util.Scanner;

/*
 * Schreiben Sie ein Programm LeapYear, das eine Jahreszahl von der Konsole einliest und dann bestimmt,
 * ob es sich bei diesem Jahr um ein Schaltjahr handelt!
 *
 * Das Ergebnis soll auf der Konsole ausgegeben werden.
 * Ein Jahr ist ein Schaltjahr, wenn es durch vier teilbar ist, nicht aber,
 * wenn es durch 100 teilbar ist, es sei denn, es ist durch 400 teilbar.
 */
public class Aufgabe1 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            System.out.print("\nZahl 🥺👉👈 > ");
            final int year = scanner.nextInt();

            // wenn durch 4 Teilbar, dann Schaltjahr,
            if (year % 4 == 0) {
                // ausser wenn durch 100 Teilbar,
                // ausser wenn durch 400 Teilbar. Dann ist wieder ok.
                if (year % 100 != 0 || year % 400 == 0) {
                    System.out.println(year + " ist Schaltjahr");
                    continue;
                }
            }
            System.out.println(year + " ist kein Schaltjahr");
        }

    }

}
