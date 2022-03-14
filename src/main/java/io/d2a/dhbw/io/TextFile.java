package io.d2a.dhbw.io;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TextFile implements AutoCloseable, Closeable {

    private final File file;

    private List<String> content = new ArrayList<>();

    ///

    public TextFile(final File file) {
        this.file = file;
    }

    public TextFile(final String fileName) {
        this.file = new File(fileName);
    }

    ///

    public void read() throws IOException {
        this.content = Files.readAllLines(this.file.toPath());
    }

    public void write() throws IOException {
        Files.write(this.file.toPath(), this.content);
    }

    public int availableLines() {
        return this.content.size();
    }

    public String[] getLines() {
        return this.content.toArray(new String[0]);
    }

    public String getLine(final int i) throws IOException {
        if (i < 1 || i > this.availableLines()) {
            throw new LineNumberOutOfBoundsException();
        }
        return this.content.get(i - 1);
    }

    public void setLine(final int i, final String seq) {
        this.content.set(i, seq);
    }

    public void replaceAll(final String haystack, final String needle) {
        final List<String> copy = new ArrayList<>(this.content);
        for (int i = 0; i < copy.size(); i++) {
            this.content.set(i, copy.get(i).replaceAll(haystack, needle));
        }
    }

    @Override
    public void close() throws IOException {
        this.content.clear();
        // cannot close file o.0
    }

}
