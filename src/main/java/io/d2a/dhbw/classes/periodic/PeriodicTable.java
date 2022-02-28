package io.d2a.dhbw.classes.periodic;

public class PeriodicTable {

    private final Element[] elements = new Element[118];

    public void addElement(final Element element) {
        this.elements[element.getOrdinal() - 1] = element;
    }

    public boolean hasElement(final int ordinal) {
        return ordinal > 0
            && this.elements.length > ordinal
            && this.elements[ordinal - 1] != null;
    }

    public Element getElement(final int ordinal) {
        return this.elements[ordinal - 1];
    }

    public Element[] getElements() {
        return elements;
    }

}
