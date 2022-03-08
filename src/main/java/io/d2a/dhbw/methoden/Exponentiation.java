package io.d2a.dhbw.methoden;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.common.Range;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import io.d2a.eeee.converter.StringConverter;

public class Exponentiation {

    public static double xPowerN(double x,int n) {
        if (n == 0) {
            return 1;
        }
        return x * xPowerN(x, n - 1);
    }

    public static void main(String[] args) throws Exception {
        Starter.start(Exponentiation.class, args);
    }

    @Entrypoint
    public void run(
        @Prompt("Geben Sie bitte die Basis ein")
        final double x,
        @Prompt("Geben Sie bitte den positiven ganzzahligen Exponenten ein") @Range({0, 100})
        final int n
    ) {
        System.out.println("x" + StringConverter.toPowString(n) + " = " + xPowerN(x, n));
    }

}
