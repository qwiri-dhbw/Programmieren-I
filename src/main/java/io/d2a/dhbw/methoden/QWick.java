package io.d2a.dhbw.methoden;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.common.Range;
import io.d2a.eeee.annotation.annotations.generate.Fill;
import io.d2a.eeee.annotation.annotations.generate.Generate;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import io.d2a.eeee.annotation.annotations.prompt.Split;
import io.d2a.eeee.generate.random.Generators;
import io.d2a.eeee.prompt.wrappers.ArrayWrapper;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QWick {

    public static void main(final String[] args) throws Exception {
        Starter.start(QWick.class, args);
    }

    @Entrypoint(loop = true, stopwatch = true)
    public void run(
        @Prompt("geb nummern du unglaeubiger") @Split("") final Integer[] numbers
    ) {
        final List<Integer> list = Arrays.asList(numbers);
        Collections.sort(list);
        System.out.println(list);
    }

}
