package io.d2a.dhbw.methoden;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import io.d2a.eeee.annotation.annotations.prompt.Split;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
