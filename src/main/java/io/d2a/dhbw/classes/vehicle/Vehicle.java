package io.d2a.dhbw.classes.vehicle;

public class Vehicle {

    private final int wheels;

    private final int vMax;

    private int vCurrent;

    private double odometer;

    public Vehicle(final int wheels, final int vMax) {
        this.wheels = wheels;
        this.vMax = vMax;
    }

    public void setSpeed(final int vCurrent) {
        this.vCurrent = Math.min(this.vMax, vCurrent);
    }

    public void drive(final double minutes) {
        final double h = minutes / 60;
        this.odometer += h * this.vCurrent;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "wheels=" + wheels +
            ", max=" + vMax +
            " km/h, current=" + vCurrent +
            " km/h, odometer=" + odometer +
            " km }";
    }

    public int getvMax() {
        return vMax;
    }
}
