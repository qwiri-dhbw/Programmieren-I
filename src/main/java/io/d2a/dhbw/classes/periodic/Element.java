package io.d2a.dhbw.classes.periodic;

import io.d2a.eeee.table.Column;
import io.d2a.eeee.table.HeaderOrder;
import java.util.Objects;

@HeaderOrder({"Name", "Symbol", "Ordinal", "Shell", "Phase", "Group"})
public class Element {

    public static final int PHASE_SOLID = 1;
    public static final int PHASE_LIQUID = 2;
    public static final int PHASE_GAS = 3;

    public static final boolean GROUP_MAIN = true;
    public static final boolean GROUP_SIDE = false;

    @Column("Name")
    private final String name;

    @Column("Symbol")
    private final String symbol;

    @Column("Ordinal")
    private final int ordinal;

    @Column("Shell")
    private final char shell;

    @Column("Phase")
    private final int phase;

    @Column("Group")
    private final boolean group;

    public Element(final String name, final String symbol, final int ordinal, final char shell,
        final int phase, final boolean group) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.group = group;
    }

    @Override
    public String toString() {
        return String.format(
            "%s (%s,%d) Schale: %c, %s, Gruppe: %s",
            this.name, this.symbol, this.ordinal, this.shell,
            this.phase == PHASE_SOLID ? "fest" : this.phase == PHASE_GAS ? "gas" : "fluessig",
            this.group == GROUP_MAIN ? "Hauptgruppe" : "Nebengruppe"
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Element element = (Element) o;
        return ordinal == element.ordinal && shell == element.shell && phase == element.phase
            && group == element.group && name.equals(element.name) && symbol.equals(element.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, ordinal, shell, phase, group);
    }

    public char getShell() {
        return shell;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public int getPhase() {
        return phase;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isGroup() {
        return group;
    }
}
