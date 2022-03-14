package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Pattern;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    @Entrypoint(loop = true)
    public void run(
        @Prompt("Bitte Zahl fuer Quersumme eingeben") @Pattern("^\\d+$")
        final String inp
    ) throws IOException {
        final int res = quersumme(inp);
        System.out.printf("Quersumme von %s ist %d%n", inp, res);

        // write result to file
        final File file = new File("crosstotals.txt");
        assert file.exists() || file.createNewFile();

        try (final FileWriter writer = new FileWriter(file, true)) {
            writer.append(String.format("Quersumme von %s ist %d.%n", inp, res));
        }
    }

}
