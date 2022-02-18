package io.d2a.dhbw.klassen3;

import java.util.stream.Stream;

public class MasterMind {

    private final char[] correct;

    public MasterMind(final char[] correct) {
        this.correct = correct;
    }

    public boolean isValid(final String inp) {
        return inp.length() == this.correct.length;
    }

    // res[0] = correct
    // res[1] = wrong
    public int[] guess(final String inp) {
        final int[] res = new int[2];
        for (int i = 0; i < inp.length(); i++) {
            if (this.correct[i] == inp.charAt(i)) {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }

    public int getLength() {
        return this.correct.length;
    }

}
