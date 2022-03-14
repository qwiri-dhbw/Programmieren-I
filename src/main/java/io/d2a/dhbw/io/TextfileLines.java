package io.d2a.dhbw.io;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TextfileLines {

    private static final File file = new File("beispiel.txt");

    static {
        try {
            assert file.exists() || file.createNewFile();
        } catch (final IOException ignored) {
        }
    }

    public static void main(final String[] args) throws Exception {
        Starter.start(TextfileLines.class, args);
    }

    @Entrypoint
    public void run() throws IOException {

        final int start = 2;
        final int end = 5;

        final String[] lines = Files.readAllLines(file.toPath())
            .toArray(new String[0]);

        final String[] relevant = new String[end - start + 1];
        System.arraycopy(lines, 1, relevant, 0, end - start + 1);

        System.out.println(String.join("\n", relevant));
        System.out.println("Zeile 2 - 5: " + String.join("", relevant));

    }

}
