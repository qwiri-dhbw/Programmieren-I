package io.d2a.dhbw.methoden;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.common.Range;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;

public class FibonacciRecursive {

    private int fib(int n) {
        if (n <= 0) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) throws Exception {
        Starter.start(FibonacciRecursive.class, args);
    }

    @Entrypoint
    public void run(
        @Prompt("Wie viele Fibonacci-Zahlen berechnen") @Range({0, 100})
        final int x
    ) {
        for (int i = 1; i <= x; i++) {
            System.out.printf("F(%d) = %d%n", i, fib(i));
        }
    }

}
