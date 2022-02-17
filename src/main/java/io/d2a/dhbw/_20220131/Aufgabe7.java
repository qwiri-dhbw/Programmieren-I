package io.d2a.dhbw._20220131;

/*
 * Das Babylonische Wurzelziehen (oft auch Heron-Verfahren)
 * ist ein alter iterativer Algorithmus zur Bestimmung einer
 * rationalen Näherung der Quadratwurzel einer Zahl.
 *
 * Es ist ein Spezialfall des Newton-Verfahrens.
 *
 * Hierbei steht a für die Zahl, deren Quadratwurzel bestimmt werden soll.
 * Der Startwert x0 der Iteration kann, solange er nicht gleich 0 (Null) ist,
 * beliebig festgesetzt werden, wobei zu beachten ist,
 * dass negative Werte gegen die negative Quadratwurzel konvergieren.
 *
 * Implementieren Sie das Babylonische Wurzelziehen so,
 * dass eine Zahl eingelesen und deren Wurzel auf 6 Stellen hinter dem Komma genau berechnet wird
 * (bzw. bis der Betrag von xn+1 - xn kleiner als 10-6 ist)!
 *
 * Geben Sie zur Kontrolle die Werte der einzelnen Berechnungsschritte aus!
 */
public class Aufgabe7 {

    public static final double WIGGLE = Math.pow(10, -6);

    public static void main(String[] args) {
        final int num = 7;

        double res;
        int it = 0;

        do {
            res = f(++it, num);
            System.out.println("Res after " + it + " -> " + res);
        } while (Math.abs((res * res) - num) > WIGGLE);

        System.out.println(res);
    }

    public static double f(final int xn, final int a) {
        return (
            xn + ((a * 1.0) / xn)
        ) / 2D;
    }

}
