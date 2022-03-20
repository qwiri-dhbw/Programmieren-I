package io.d2a.dhbw.io;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Pattern;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PalindromeFile {

    public static void main(final String[] args) throws Exception {
        Starter.byCaller();
    }

    @Entrypoint(loop = true)
    public void run(
        @Prompt("Wort") @Pattern("^[\\w]+$") final String word
    ) throws IOException {

        final File file = new File("palindromes.txt");
        // check if file exists and create if not
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("cannot create file");
        }

        final String reversed = new StringBuilder(word).reverse().toString();
        if (reversed.equalsIgnoreCase(word)) {
            System.out.printf("👏 %s ist ein Palindrom!%n%n", word);
            try (final FileWriter writer = new FileWriter(file, true)) {
                writer.write(word.toLowerCase() + "\n");
            }
        } else {
            System.out.printf("🫠 %s ist kein Palindrom!%n%n", word);
        }

        System.out.println("Alle bisher gefundenen Palindrome:");
        try (final Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }

        // Files.readAllLines(file.toPath()).forEach(System.out::println);
    }

}
