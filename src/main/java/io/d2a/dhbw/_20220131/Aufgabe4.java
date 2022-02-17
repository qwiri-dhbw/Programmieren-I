package io.d2a.dhbw._20220131;

/*
 * Entwickeln Sie ein Programm MultiplicationTable,
 * welches das kleine Einmaleins in Tabellenform (10x10-Tabelle) ausgibt!
 */
public class Aufgabe4 {

    public static void main(String[] args) {
        final int size = 10;
        final int padding = (int) Math.ceil(Math.log10( size * size )) + 2;
        for (int i = 1; i <= size; i++) {
            for (int k = 1; k <= size; k++) {
                System.out.printf("%" + padding + "d", i * k);
            }
            System.out.println();
        }
    }

}
