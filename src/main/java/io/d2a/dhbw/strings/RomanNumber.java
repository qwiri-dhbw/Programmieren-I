package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.Prompt;
import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    public static final boolean VERBOSE = true;

    public static final Map<Character, Integer> VALUES = new HashMap<>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};

    ///

    public static void main(String[] args) throws Exception {
        while(true) Starter.start(RomanNumber.class, args);
    }

    ///

    @Entrypoint(verbose = VERBOSE, stopwatch = false)
    public void run(
        @Prompt("Roemische Number") final String input
    ) {
        final char[] chars = input.toCharArray();

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            final int currentValue = VALUES.get(chars[i]);

            final int nextValue;
            if ((i + 1) < chars.length) {
                nextValue = VALUES.get(chars[i + 1]);
            } else {
                nextValue = 0;
            }

            if (currentValue >= nextValue) {
                res += currentValue;
            } else {
                res -= currentValue;
            }

            if (VERBOSE) {
                final String mode = currentValue >= nextValue ? "add" : "sub";
                System.out.printf("%c | %4d | %3s | %4d%n",
                    chars[i], currentValue, mode, res);
            }
        }

        System.out.printf("%s = %d.%n", input, res);
    }

}
