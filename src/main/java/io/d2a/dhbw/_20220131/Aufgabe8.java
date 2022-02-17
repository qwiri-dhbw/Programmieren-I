package io.d2a.dhbw._20220131;

import java.util.Scanner;

/*
 * Schreiben Sie eine Java-Applikation NumberGuess, die ein einfaches Ratespiel implementiert!
 * Bei diesem Ratespiel muss der Benutzer eine zufällig erzeugte Zahl zwischen 1 und 100 erraten.
 *
 * Als Hinweis bekommt er jeweils angezeigt, ob er zu hoch oder zu niedrig getippt hat.
 * Die Anzahl der Versuche, die er benötigt, wird mitgezählt.
 * Der Benutzer soll folgendes eingeben können:
 *      * Spielername
 *      * Jeweils die nächste zu tippende Zahl
 *      * Endabfrage, ob die Applikation beendet werden (Eingabewert: „0“)
 *        oder ein weiteres Spiel durchgeführt werden soll (Eingabewert: „1“).
 * Das Programm soll nach Eingabe eines Tipps prüfen, ob die aktuelle Eingabe höher, niedriger oder gleich der gesuchten Zahl ist.
 * Es soll dann die Nummer des Versuches ausgeben und ob der Tipp zu hoch, zu niedrig oder korrekt war.
 */
public class Aufgabe8 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // ask for player name
        String playerName;
        System.out.print("Spielername > ");
        while ((playerName = scanner.nextLine().trim()).length() <= 0) {
            System.out.print("Spielername wird benoetigt > ");
        }

        System.out.printf("Hi %s! Du kannst jetzt anfangen zu raten.%n", playerName);

        // new round loop
        for (; ; ) {
            final int randomNumber = (int) ((Math.random() * 100) % 98) + 2;

            // left for debugging purposes
            System.out.println("// random: " + randomNumber);

            System.out.println("Eine neue Runde startet!");
            System.out.println(" 0 - Spiel beenden");
            System.out.println(" 1 - Neues Spiel beginnen");
            System.out.println(" * - Zahl raten");

            int tries = 0;

            b: // i am so sorry.
            for (; ; ++tries) {
                System.out.printf("%s, rate eine Zahl > ", playerName);
                final int num = scanner.nextInt();
                switch (num) {
                    case 0:
                        // exit app
                        System.out.println("Bundesgartentschau!");
                        return;
                    case 1:
                        // start a new round
                        break b;
                    default:
                        if (num == randomNumber) {
                            System.out.printf("Die Zahl %d war es! Versuche gebraucht: %d%n",
                                randomNumber, tries + 1);
                            break b;
                        } else {
                            System.out.println("Deine geratene Zahl ist zu " + (
                                num < randomNumber ? "klein" : "gross"
                            ));
                        }
                }
            }

        }
    }

}
