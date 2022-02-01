package io.d2a.dhbw._20220131;

/*
 * Für die Umrechnung der in Deutschland üblichen Schuhgrößen in Zentimeter gilt die folgende Beziehung:
 *
 * Schuhgröße = Zentimeter * 1,5
 */
public class Aufgabe6 {

    public static void main(String[] args) {
        for (int i = 30; i < 50; i++) {
            final double cm = i / 1.5;
            System.out.printf("%2.2fcm - %2.2fcm | Groesse %2d%n", cm - (2D/3), cm, i);
        }
    }

}
