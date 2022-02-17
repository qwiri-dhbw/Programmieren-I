package io.d2a.dhbw.klassen2;

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
    public double[] zeroes() {
        final double a = -(this.b / 2) + Math.sqrt(
            (this.b / 2) * (this.b / 2) - this.c
        );
        final double b = -(this.b / 2) - Math.sqrt(
            (this.b / 2) * (this.b / 2) - this.c
        );
        return new double[]{a, b};
    }

}
