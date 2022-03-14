package io.d2a.dhbw.io;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import java.io.File;
import java.util.Objects;

public class FileExperiments {

    public static void main(final String[] args) throws Exception {
        Starter.start(FileExperiments.class, args);
    }

    @Entrypoint
    public void run() throws Exception {
        final File parent = new File("myDir");
        if (!parent.exists()) {
            if (!parent.mkdirs()) {
                System.out.println("cannot create directories.");
                return;
            }
            System.out.println("created myDir.");
        } else {
            if (!parent.isDirectory()) {
                System.out.println("myDir exists, but not as a directory");
                return;
            }
        }

        for (int i = 1; i <= 3; i++) {
            final File child = new File(parent, "foo" + i);
            System.out.print(child + ": ");

            // create child
            if (!child.exists()) {
                if (!child.createNewFile()) {
                    System.out.println("error creating");
                    continue;
                }
                System.out.println("created!");
                continue;
            }
            System.out.println("already exists!");
        }

        // print out all files in the parent directory
        System.out.println("\nmyDir");
        final File[] files = Objects.requireNonNull(parent.listFiles());
        for (int i = 0; i < files.length; i++) {
            final File child = files[i];

            final char prefix;
            if (i == files.length - 1) {
                prefix = '└';
            } else {
                prefix = '├';
            }

            System.out.println(prefix + " " + child);
        }
    }

}
