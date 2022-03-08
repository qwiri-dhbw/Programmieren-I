package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Pattern;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;

public class CrossTotal {

    public static void main(String[] args) throws Exception {
        Starter.start(CrossTotal.class, args);
    }

    public static int quersumme(final String in) {
        int res = 0;
        for (final char c : in.toCharArray()) {
            res += c - '0';
        }
        return res;
    }

    @Entrypoint
    public void run(
        @Prompt("Bitte Zahl fuer Quersumme eingeben") @Pattern("^\\d+$")
        final String inp
    ) {
        System.out.printf("Quersumme von %s ist %d%n", inp, quersumme(inp));
    }

}
