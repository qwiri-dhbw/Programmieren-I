package io.d2a.dhbw.io;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class PalindromeFile {

    public static void main(final String[] args) throws Exception {
        Starter.start(PalindromeFile.class, args);
    }

    @Entrypoint(loop = true)
    public void run(
        @Prompt("Bitte Wort eingeben") final String word
    ) throws IOException {
        final File file = new File("palindromes.txt");
        assert file.exists() || file.createNewFile();

        // get reversed word
        final String reversed = new StringBuilder(word).reverse().toString();
        if (reversed.equalsIgnoreCase(word)) {
            System.out.printf("%s ist ein Palindrom!%n", word);

            // write word to file
            try (final FileWriter writer = new FileWriter(file, true)) {
                writer.write(word.toLowerCase() + "\n");
            }
        }

        // read all word from file
        System.out.println("Alle bisher gefundenen Palindrome:");
        Files.readAllLines(file.toPath()).forEach(System.out::println);
    }

}
