package io.d2a.dhbw;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Pattern;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import java.math.BigInteger;

public class GGT {

    public static void main(final String[] args) throws Exception {
        Starter.start(GGT.class, args);
    }

    @Entrypoint(loop = true, stopwatch = true)
    public void run(
        @Prompt("Zahl 1") @Pattern("^\\d+$") final String a,
        @Prompt("Zahl 2") @Pattern("^\\d+$") final String b
    ) {
        System.out.printf("ggT (%s, %s) = %s%n", a, b, new BigInteger(a).gcd(new BigInteger(b)));
    }

}
