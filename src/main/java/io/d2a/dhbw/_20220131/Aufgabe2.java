package io.d2a.dhbw._20220131;

/*
 * Erstellen Sie ein Programm zur Ausgabe einer Temperaturtabelle von Fahrenheit (f) nach Celsius (c)!
 * Die Tabelle soll bei 0° F beginnen und bei 300° F enden.
 * Die Abstände der Stützstellen sollen 20° F betragen.
 *
 * Der funktionale Zusammenhang von c und f ist gegeben durch die Formel:
 * c = (5 / 9) * (f - 32)
 */
public class Aufgabe2 {

    public static void main(String[] args) {
        System.out.println("Fahrenheit (f) | Celsius (c)");
        System.out.println("-------------- + -----------");
        for (int i = 0; i <= 300; i+=20) {
            System.out.printf("%14d | %11f%n", i, (5D/9D) * (i - 32));
        }
    }

}
