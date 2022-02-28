package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.Prompt;

public class Palindrome {

    public static boolean isPalindrome(final String input) {
        final StringBuilder bob = new StringBuilder(input).reverse();
        return bob.toString().equalsIgnoreCase(input);
    }

    public static void main(String[] args) throws Exception {
        Starter.start(Palindrome.class, args);
    }

    @Entrypoint(loop = true)
    public void run(@Prompt("Eingabe") final String inp) {
        System.out.printf("Die Eingabe ist %s Palindrome.%n",
            isPalindrome(inp) ? "ein" : "kein");
    }

}
