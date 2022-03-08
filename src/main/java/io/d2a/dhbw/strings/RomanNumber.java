package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Pattern;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    public static void main(String[] args) throws Exception {
        Starter.start(RomanNumber.class, args);
    }

    /// MCMLXXXIV

    public static final Map<Character, Integer> VALUES = new HashMap<>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};

    @Entrypoint(loop = true)
    public void run(
        @Prompt("Roemische Number") @Pattern("^[MDCLXVI]+$")
        final String input
    ) {
        final char[] chars = input.toCharArray();

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            final int currentValue = VALUES.get(chars[i]);

            boolean add = true;
            for (int j = i; j < chars.length; j++) {
                final int nextValue = VALUES.get(chars[j]);
                if (nextValue > currentValue) {
                    add = false;
                    break;
                } else if (nextValue < currentValue) {
                    break;
                }
            }

            if (add) {
                res += currentValue;
            } else {
                res -= currentValue;
            }

            final String mode = add ? "add" : "sub";
            System.out.printf("%c | %4d | %3s | %4d%n",
                chars[i], currentValue, mode, res);
        }

        System.out.printf("%s = %d.%n", input, res);
    }

}
