package io.d2a.dhbw.klassen2;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.generate.random.RandomFactory;
import java.util.Arrays;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws Exception {
        Starter.start(Test.class, args);
    }

    @Entrypoint
    public void poly() throws NoSuchMethodException {
        final Polynomial a = new Polynomial(2.0, 0, 0);
        final Polynomial b = new Polynomial(0.0, -4, 1);
        System.out.println("P1: " + a);
        System.out.println("P2: " + b);
        final Polynomial c = a.add(b);
        final Polynomial d = c.skalar(2);
        System.out.println("P3: " + c);
        System.out.println("P4: " + d);
        System.out.println("Nst von P3: " + d + " :: " + Arrays.toString(d.zeroes()));
    }

    @Entrypoint
    public void complex() throws Exception {
        final Complex c1 = new Complex(1, 2);
        final Complex c2 = new Complex(2, 1);
        final Complex c1ac2 = c1.add(c2);
        final Complex c1sc2 = c1.sub(c2);
        final Complex c1mc2 = c1.mult(c2);
        final Complex c1dc2 = c1.div(c2);
        final boolean c1lc2 = c1.isLess(c2);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C1 + C2: " + c1ac2);
        System.out.println("C1 - C2: " + c1sc2);
        System.out.println("C1 * C2: " + c1mc2);
        System.out.println("C1 / C2: " + c1dc2);
        System.out.println("C1 < C2: " + c1lc2);

        final Complex[] complexes = new Complex[10];
        RandomFactory.fill(complexes);

        System.out.println("Unsortiert:");
        for (final Complex complex : complexes) {
            System.out.printf("%s Betrag: %.3f%n", complex, complex.getMagnitude());
        }

        final Complex[] complexesSorted = Stream.of(complexes).sorted((o1, o2) -> {
            final double m1 = o1.getMagnitude();
            final double m2 = o2.getMagnitude();
            return Double.compare(m1, m2);
        }).toArray(Complex[]::new);

        System.out.println("Sortiert:");
        for (final Complex complex : complexesSorted) {
            System.out.printf("%s Betrag: %.3f%n", complex, complex.getMagnitude());
        }
    }

}
