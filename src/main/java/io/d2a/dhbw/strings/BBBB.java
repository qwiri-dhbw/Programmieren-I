package io.d2a.dhbw.strings;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.Fill;
import io.d2a.eeee.annotation.annotations.Generate;
import io.d2a.eeee.annotation.annotations.Use;
import io.d2a.eeee.generate.random.generators.special.NameGenerator;
import java.util.Arrays;

public class BBBB {

    public static void main(final String[] args) throws Exception {
        Starter.start(BBBB.class, args);
    }

    @Entrypoint
    public void run(
        @Generate @Fill(10) @Use(NameGenerator.class)
        final String[] array
    ) {
        System.out.println(Arrays.toString(array));
    }

}
