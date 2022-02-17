package io.d2a.dhbw._20220214.clazz;

public class Radio {

    private boolean on;
    private int volume;
    private float frequency;

    public Radio(final boolean on, final int volume, final float frequency) {
        this.on = on;
        this.volume = volume;
        this.frequency = frequency;
    }

    public void incVolume() {
        if (!this.on) {
            return;
        }
        this.volume = Math.min(10, this.volume + 1);
    }

    public void decVolume() {
        if (!this.on) {
            return;
        }
        this.volume = Math.max(0, this.volume - 1);
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void setFrequency(final float frequency) {
        this.frequency = Math.min(110, frequency);
    }

    @Override
    public String toString() {
        return String.format("Radio %s: Freq=%.1f,Laut=%d",
            (this.on ? "an" : "aus"), this.frequency, this.volume);
    }

}
