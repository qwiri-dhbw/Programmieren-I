package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.Prompt;

public class CrossTotal {

    public static void main(String[] args) throws Exception {
        Starter.start(CrossTotal.class, args);
    }

    public static int quersumme(final String in) {
        int res = 0;
        for (final char c : in.toCharArray()) {
            res += c - 48;
        }
        return res;
    }

    @Entrypoint(verbose = false, stopwatch = false)
    public void run(
        @Prompt("Bitte Zahl fuer Quersumme eingeben") final String inp
    ) {
        System.out.printf("Quersumme von %s ist %d%n", inp, quersumme(inp));
    }

}
