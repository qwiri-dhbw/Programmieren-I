package io.d2a.dhbw.io;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Default;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TextfileLines {

    private static final File file = new File("beispiel.txt");

    public static void main(final String[] args) throws Exception {
        assert file.exists() || file.createNewFile();
        Starter.start(TextfileLines.class, args);
    }

    @Entrypoint
    public void run(
        @Prompt("start") @Default("2") final int start,
        @Prompt("end") @Default("5") final int end
    ) throws IOException {
        final String[] lines = Files.readAllLines(file.toPath())
            .toArray(new String[0]);

        final String[] relevant = new String[end - start + 1];
        System.arraycopy(lines, 1, relevant, 0, end - start + 1);

        System.out.println(String.join("\n", relevant));
        System.out.println("Zeile 2 - 5: " + String.join("", relevant));

    }

}
