package io.d2a.dhbw.wechselspiel;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {

    private static final Random random = new Random();
    private static final String alph = "ABCDEFGHI";

    ///

    private final String[][] fields;

    ///

    public Spielfeld() {
        this.fields = new String[9][9];
        for (int i = 0; i < this.fields.length; i++) {
            for (int j = 0; j < this.fields[i].length; j++) {
                String color;

                // generate random color for spot and
                // make sure we don't have 3 same colors in the current row/column
                do {
                    color = Knorr.COLORS[random.nextInt(Knorr.COLORS.length)];
                } while (
                    (j > 1
                        && color.equals(this.fields[i][j - 1])
                        && color.equals(this.fields[i][j - 2])
                    ) || (i > 1
                        && color.equals(this.fields[i - 1][j])
                        && color.equals(this.fields[i - 2][j])
                    )
                );

                this.fields[i][j] = color;
            }
        }
    }

    ///

    public String[][] copy() {
        final String[][] res = new String[9][9];
        for (int i = 0; i < this.fields.length; i++) {
            System.arraycopy(this.fields[i], 0, res[i], 0, this.fields[i].length);
        }
        return res;
    }

    /**
     * Dear God, please forgive me this mess. 🙏
     * @return fields to remove
     */
    public boolean[][] remove() {
        final boolean[][] removers = new boolean[9][9];

        // horizontal
        for (int i = 0; i < this.fields.length; i++) {
            String last = "";
            int count = 0;

            for (int j = 0; j < this.fields[i].length; j++) {
                final String color = this.fields[i][j];

                if (last.equals(color)) {
                    count++;

                    // we found more than 3 colors in a row
                    if (count >= 3) {
                        for (int x = 0; x < count; x++) {
                            removers[i][j - x] = true;
                        }
                    }
                } else {
                    count = 1;
                }

                last = color;
            }
        }

        // vertical
        for (int j = 0; j < this.fields.length; j++) {
            String last = "";
            int count = 0;

            for (int i = 0; i < this.fields[j].length; i++) {
                final String color = this.fields[i][j];

                if (last.equals(color)) {
                    count++;

                    // we found more than 3 colors in a row
                    if (count >= 3) {
                        for (int x = 0; x < count; x++) {
                            removers[i - x][j] = true;
                        }
                    }
                } else {
                    count = 1;
                }

                last = color;
            }
        }

        return removers;
    }

    public void swap(final int rowA, final int colA, final int rowB, final int colB) {
        final String temp = this.fields[rowA][colA];
        this.fields[rowA][colA] = this.fields[rowB][colB];
        this.fields[rowB][colB] = temp;
    }

    public void gravity() {
        for (int i = 0; i < this.fields.length; i++) {
            for (int j = 0; j < this.fields[i].length; j++) {
                final int index = this.fields[i].length - 1 - j;
                final String color = this.fields[index][i];

            }
        }
    }

    ///

    @Override
    public String toString() {
        final StringBuilder bob = new StringBuilder();
        bob.append("  A  B  C  D  E  F  G  H  I").append('\n');
        for (int i = 0; i < this.fields.length; i++) {
            bob.append(i + 1).append(' ');

            for (final String color : this.fields[i]) {
                bob.append(color).append("  ").append(Knorr.ANSI_RESET).append(' ');
            }
            bob.append('\n').append('\n');
        }
        return bob.toString();
    }

    public static void main(String[] args) {
        final Spielfeld spielfeld = new Spielfeld();
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(spielfeld);
            System.out.println();
            System.out.print("Swap ([Xi] [Yj]) > ");

            final String action = scanner.nextLine().trim().toUpperCase();
            final String[] spl = action.split("\s");
            if (spl.length != 2) {
                System.out.println("Invalid Arg.");
                continue;
            }

            final String a = spl[0], b = spl[1];
            final int cA = alph.indexOf(a.charAt(0)), cB = alph.indexOf(b.charAt(0));
            final int rA = Integer.parseInt(String.valueOf(a.charAt(1))) - 1, rB =
                Integer.parseInt(String.valueOf(b.charAt(1))) - 1;

            System.out.printf("Swapping %d:%d w/ %d:%d%n", rA, cA, rB, cB);
            spielfeld.swap(rA, cA, rB, cB);

            boolean removed = false;
            final boolean[][] removers = spielfeld.remove();
            for (int i = 0; i < removers.length; i++) {
                for (int j = 0; j < removers[i].length; j++) {
                    if (removers[i][j]) {
                        spielfeld.fields[i][j] = Knorr.ANSI_BG_BLACK;
                        removed = true;
                    }
                }
            }

            // swap back
            if (!removed) {
                spielfeld.swap(rA, cA, rB, cB);
                System.out.println("Das hat nichts gebracht.");
                System.out.println();
                continue;
            }

            boolean didSomething;

            do {
                spielfeld.gravity();

                System.out.println("After Gravity");
                System.out.println(spielfeld);

                didSomething = false;
                final boolean[][] rem = spielfeld.remove();
                for (int i = 0; i < rem.length; i++) {
                    for (int j = 0; j < rem[i].length; j++) {
                        if (rem[i][j]) {
                            spielfeld.fields[i][j] = Knorr.ANSI_BG_BLACK;
                            didSomething = true;
                        }
                    }
                }

                System.out.println("After removal:");
                System.out.println(spielfeld);
            } while (didSomething);

        }
    }

}
