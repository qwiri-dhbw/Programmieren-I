package io.d2a.dhbw.klassen3;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.ForceRun;
import io.d2a.eeee.annotation.annotations.Prompt;
import io.d2a.eeee.wrapper.Wrappers;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final Random RANDOM = new Random();
    public static final char[] CHARS = "ABCDEFGH".toCharArray();

    public static void main(String[] args) throws Exception {
        Starter.start(Main.class, args);
    }

    @Entrypoint
    @ForceRun
    public void mm(final Scanner scanner) {
        // generate random word
        final char[] word = new char[5];
        for (int i = 0; i < word.length; i++) {
            word[i] = CHARS[RANDOM.nextInt(CHARS.length)];
        }

        final MasterMind mm = new MasterMind(word);
        System.out.printf("Das Wort ist %d lang.%n", word.length);

        int tries = 0;
        while (true) {
            System.out.printf("Versuch %d: ", ++tries);
            final String guess = scanner.nextLine().trim().toUpperCase();
            if (!mm.isValid(guess)) {
                System.out.println("Ungueltiges Wort.");
                continue;
            }
            final int[] res = mm.guess(guess);
            // check if correct
            if (res[0] == mm.getLength()) {
                System.out.printf("Wort erraten nach %d Versuchen! :)%n", tries);
                return;
            }

            System.out.printf("%6s %2d %2d%n", guess, res[0], res[1]);
        }
    }

    @Entrypoint("Lotto")
    public void lotto() throws Exception {
        final Lotto lotto = new Lotto(7, 49);
        final int[] tip = lotto.tippen();
        lotto.tippen(tip);
        lotto.ziehen();

        System.out.println(lotto.richtige() + " richtige!");
        System.out.println();
        System.out.println("ZIEH: " + Arrays.toString(lotto.getZiehung()));
        System.out.println("RICH: " + Arrays.toString(tip));
    }

    @Entrypoint
    public void run(
        final Scanner scanner,
        @Prompt("Wie viele Spieler?")
        final int numberPlayers,
        @Prompt("Wie viele Haufen?")
        final int numberHaufen
    ) {
        final Random random = new Random();

        final int[] haufen = new int[numberHaufen];
        for (int i = 0; i < haufen.length; i++) {
            haufen[i] = RANDOM.nextInt(10 - 1) + 1;
        }

        final String[] names = new String[numberPlayers];
        for (int i = 0; i < names.length; i++) {
            names[i] = Wrappers.prompt(scanner, String.class, "Name Spieler " + (i + 1));
        }

        final Nimmspiel nimmspiel = new Nimmspiel(haufen, names);

        while (true) {
            System.out.println();
            System.out.println(nimmspiel.getCurrentPlayer() + ", du bist am Zug!");
            System.out.println(nimmspiel.toHaufenString());

            int h;
            while (true) {
                h = Wrappers.prompt(
                    scanner,
                    int.class,
                    "Von welchem Haufen moechtest du eine Kugel nehmen?"
                );
                if (h >= 0 && h < haufen.length) {
                    if (haufen[h] == 0) {
                        System.out.println("Der Haufen ist bereits leer.");
                        continue;
                    }
                    break;
                }
                System.out.println("Dieser Haufen existiert nicht.");
            }

            int num;
            while (true) {
                num = Wrappers.prompt(
                    scanner,
                    int.class,
                    "Wie viele Kugeln?"
                );
                if (num > 0 && num <= haufen[h]) {
                    break;
                }
                System.out.println("So viele Kugeln hat der Haufen nicht.");
            }

            if (!nimmspiel.take(h, num)) {
                System.out.println("Es ist ein Fehler unterlaufen.");
                return;
            }

            if (nimmspiel.empty()) {
                System.out.printf("%s hat gewonnen!%n", nimmspiel.getCurrentPlayer());
                return;
            }

            nimmspiel.nextPlayer();
        }
    }

}
