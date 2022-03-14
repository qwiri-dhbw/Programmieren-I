package io.d2a.dhbw.io;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TextFileTest {

    public static void main(final String[] args) throws Exception {
        Starter.start(TextFile.class, args);
    }

    @Entrypoint
    public void run() throws IOException {
        final File file = new File("bla.txt");
        final TextFile textFile = new TextFile(file);
        textFile.read();

        System.out.println(Arrays.toString(textFile.getLines()));
        textFile.replaceAll("meine", "unsre");
        System.out.println(Arrays.toString(textFile.getLines()));
    }


}
