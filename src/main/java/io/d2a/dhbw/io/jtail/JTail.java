package io.d2a.dhbw.io.jtail;

import io.d2a.eeee.argparse.Flags;
import io.d2a.eeee.argparse.flags.LongFlag;
import io.d2a.eeee.argparse.flags.StringFlag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JTail {

    private static final StringFlag fileFlag = new StringFlag("file");
    private static final LongFlag linesFlag = new LongFlag("lines");
    private static final LongFlag bytesFlag = new LongFlag("bytes");

    public static void main(String[] args) throws JTailException {
        Flags.parse(args);

        // check required flag
        final String fileName = fileFlag.get();
        if (fileName == null || fileName.isBlank()) {
            System.out.println("--file required.");
            return;
        }

        // check if specified file exists
        final File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File doesn't exist!");
            return;
        }

        try {
            run(file);
        } catch (final Exception e) {
            wrapException(e);
        }
    }

    private static void run(final File file) throws IOException {
        // by line
        // shorter way: final String data = String.join("\n", Files.readAllLines(file));
        final StringBuilder bob = new StringBuilder();
        try (final FileReader fileReader = new FileReader(file)) {
            int i;
            while ((i = fileReader.read()) != -1) {
                bob.append((char) i);
            }
        }

        if (linesFlag.isUpdated() || !bytesFlag.isUpdated()) {
            final String[] split = bob.toString().split("\\n");

            final int lines = Math.min(linesFlag.get(10L).intValue(), split.length);
            if (lines < 0) {
                System.out.println("Lines cannot be negative");
                return;
            }
            final String[] relevant = new String[(int) lines];
            System.arraycopy(split, split.length - lines, relevant, 0, lines);

            System.out.println(String.join("\n", relevant));
            return;
        }

        final int bytes = Math.min(bytesFlag.get().intValue(), bob.length());
        if (bytes < 0) {
            System.out.println("Bytes cannot be negative");
            return;
        }
        System.out.println(bob.substring(bob.length() - bytes));
    }

    private static void wrapException(final Exception exception) throws JTailException {
        if (exception instanceof FileNotFoundException fnfe) {
            throw new JTailFileNotFoundException(fnfe.getMessage());
        } else if (exception instanceof IOException ioex) {
            throw new JTailIOException(ioex.getMessage());
        } else {
            throw new JTailInvalidExceptionException("cannot find wrapper for exception " +
                exception.getClass().getSimpleName() +
                " :: " +
                exception.getMessage());
        }
    }

}
