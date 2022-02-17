package io.d2a.dhbw.klassen2;

import io.d2a.eeee.annotations.generate.Generate;

public class Complex {

    private final double a;
    private final double b;

    @Generate
    public Complex(
        final double a,
        final double b
    ) {
        this.a = a;
        this.b = b;
    }

    ///

    public Complex add(final Complex b) {
        return new Complex(this.a + b.a, this.b + b.b);
    }

    public Complex sub(final Complex b) {
        return new Complex(this.a - b.a, this.b - b.b);
    }

    public Complex mult(final Complex other) {
        return new Complex(
            this.a * other.a - this.b * other.b,
            this.a * other.b + this.b * other.a
        );
    }

    public Complex div(final Complex other) {
        final double n = other.a * other.a + other.b * other.b;
        return new Complex(
            (this.a * other.a + this.b * other.b) / n,
            (this.b * other.a - this.a * other.b) / n
        );
    }

    public double getMagnitude() {
        return Math.sqrt(this.a * this.a + this.b * this.b);
    }

    public boolean isLess(final Complex other) {
        return this.getMagnitude() < other.getMagnitude();
    }

    ///

    @Override
    public String toString() {
        return String.format("%.1f + %.1fi", this.a, this.b);
    }

    public double getReal() {
        return this.a;
    }

    public double getImag() {
        return this.b;
    }
}
