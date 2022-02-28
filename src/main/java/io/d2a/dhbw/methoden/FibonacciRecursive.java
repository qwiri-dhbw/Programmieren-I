package io.d2a.dhbw.methoden;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.Prompt;
import io.d2a.eeee.annotation.annotations.Range;
import io.d2a.eeee.converter.StringConverter;

public class FibonacciRecursive {

    public static int fib(int n) {
        if (n <= 0) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) throws Exception {
        Starter.start(FibonacciRecursive.class, args);
    }

    @Entrypoint(verbose = false, stopwatch = false)
    public void run(
        @Prompt("Wie viele Fibonacci-Zahlen berechnen") @Range({0, 100})
        final int x
    ) {
        for (int i = 1; i <= x; i++) {
            System.out.printf("F(%d) = %d%n", i, fib(i));
        }
    }

}
