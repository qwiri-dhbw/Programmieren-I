package io.d2a.dhbw.classes.vehicle;

public class Car extends Vehicle {

    public Car() {
        this(140);
    }

    public Car(final int vMax) {
        super(4, vMax);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
