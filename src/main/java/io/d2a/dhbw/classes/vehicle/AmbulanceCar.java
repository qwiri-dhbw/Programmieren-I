package io.d2a.dhbw.classes.vehicle;

public class AmbulanceCar extends Car {

    private boolean blue;

    public AmbulanceCar(final int vMax, final boolean blue) {
        super(vMax);
        this.blue = blue;
    }

    public boolean isBlue() {
        return blue;
    }

    public void toggleBlue() {
        this.blue = !this.blue;
    }

    @Override
    public String toString() {
        return "AmbulanceCar{car = " + super.toString() +
            ", blue=" + blue +
            '}';
    }

}
