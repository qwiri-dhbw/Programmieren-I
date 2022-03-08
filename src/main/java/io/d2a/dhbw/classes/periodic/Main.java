package io.d2a.dhbw.classes.periodic;

import io.d2a.eeee.table.Table;
import io.d2a.eeee.table.TableBuilder;
import io.d2a.eeee.table.TableStyle;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        final PeriodicTable table = new PeriodicTable();

        Arrays.asList(
            new Element("Wasserstoff", "H", 1, 'K', Element.PHASE_GAS, Element.GROUP_MAIN),
            new Element("Helium", "He", 2, 'K', Element.PHASE_GAS, Element.GROUP_MAIN),
            new Metal("Natrium", "Na", 11, 'M', Element.PHASE_SOLID, Element.GROUP_MAIN, false, 21),
            new Metal("Eisen", "Fe", 26, 'N', Element.PHASE_SOLID, Element.GROUP_SIDE, false,
                10.02),
            new Metal("Germanium", "Ge", 32, 'N', Element.PHASE_SOLID, Element.GROUP_SIDE, false,
                1.45),
            new Element("Brom", "Br", 35, 'N', Element.PHASE_LIQUID, Element.GROUP_MAIN),
            new Metal("Tellur", "Te", 52, 'O', Element.PHASE_SOLID, Element.GROUP_MAIN, true,
                0.005),
            new Metal("Gold", "Au", 79, 'P', Element.PHASE_SOLID, Element.GROUP_SIDE, false, 44)
        ).forEach(table::addElement);

        final Table t = TableBuilder.from(table.getElements(), Element.class)
            .color(true)
            .style(TableStyle.ROUND)
            .build();

        System.out.println(t);

        System.out.println("Metalle:");
        for (final Element element : table.getElements()) {
            if (element == null) {
                continue;
            }
            if (!(element instanceof Metal)) {
                continue;
            }
            System.out.println(element);
        }

        System.out.println();
        System.out.println("Gold:");
        System.out.println(table.getElement(79));
    }

}
