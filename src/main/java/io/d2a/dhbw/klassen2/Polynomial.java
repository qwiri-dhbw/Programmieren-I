package io.d2a.dhbw.klassen2;

import io.d2a.eeee.annotation.annotations.Generate;

public class Polynomial {

    private final double a;
    private final double b;
    private final double c;

    private static char sign(final double value) {
        return value < 0 ? '-' : '+';
    }

    @Override
    public String toString() {
        return String.format("%.1f*x² %c %.1f*x %c %.1f", this.a,
            sign(this.b), Math.abs(this.b),
            sign(this.c), Math.abs(this.c));
    }

    @Generate
    public Polynomial(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double f(final double x) {
        return this.a * x * x + this.b * x + this.c;
    }

    public Polynomial add(final Polynomial b) {
        return new Polynomial(
            this.a + b.a,
            this.b + b.b,
            this.c + b.c
        );
    }

    public Polynomial sub(final Polynomial b) {
        return new Polynomial(
            this.a - b.a,
            this.b - b.b,
            this.c - b.c
        );
    }

    public Polynomial skalar(final double m) {
        return new Polynomial(
            this.a * m,
            this.b * m,
            this.c * m
        );
    }

    @Deprecated
    public double[] zeroes() throws NoSuchMethodException {
        throw new NoSuchMethodException("not implemented yet.");
    }

}
