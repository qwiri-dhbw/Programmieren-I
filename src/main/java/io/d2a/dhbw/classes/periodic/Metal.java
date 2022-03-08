package io.d2a.dhbw.classes.periodic;

public class Metal extends Element {

    private final boolean metalloid;
    private final double conductivity;

    public Metal(
        final String name,
        final String symbol,
        final int ordinal,
        final char shell,
        final int phase,
        final boolean group,
        final boolean metalloid,
        final double conductivity
    ) {
        super(name, symbol, ordinal, shell, phase, group);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s \u03C3: %f", 
            this.metalloid ? " Halbleiter," : "",
            this.conductivity);
    }

}
