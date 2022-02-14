package io.d2a.dhbw.eeee;

import io.d2a.dhbw._20220214.Test;
import io.d2a.dhbw.eeee.annotations.Entrypoint;
import io.d2a.dhbw.eeee.annotations.ForceRun;
import io.d2a.dhbw.eeee.inject.Injector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {

    public static final Class<?> FIRST_ENTRY = Test.class;

    private static RunConfig getForcedConfig(final List<? extends RunConfig> list) {
        for (final RunConfig config : list) {
            if (config.method.isAnnotationPresent(ForceRun.class)) {
                return config;
            }
        }
        return null;
    }

    private static void printConfigs(final List<? extends RunConfig> list) {
        // print method selection
        int i = 0;
        for (final RunConfig method : list) {
            // print method number and name
            System.out.printf("%d. %s::%s@%s (%s)%n",
                ++i,
                FIRST_ENTRY.getSimpleName(),
                method.entrypoint.value(),
                method.method.getName(),
                formatTypes(method.method.getParameterTypes(), false)
            );
        }
    }

    private static RunConfig select(final Scanner scanner, final List<? extends RunConfig> list) {
        // if there's only 1 method to run, just select the first
        if (list.size() == 1) {
            return list.get(0);
        }
        while (true) {
            printConfigs(list);
            System.out.printf("[?] Select Method to run [1-%d]: ", list.size());

            final String line = scanner.nextLine().trim();
            try {
                final int i = Integer.parseInt(line);
                if (i > 0 && i <= list.size()) {
                    return list.get(i - 1);
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public static String formatTypes(final Class<?>[] types, boolean sh) {
        final StringBuilder bob = new StringBuilder();
        for (final Class<?> type : types) {
            if (bob.length() > 0) {
                bob.append(",");
            }
            if (sh) {
                bob.append(type.getSimpleName().charAt(0));
            } else {
                bob.append(type.getSimpleName());
            }
        }
        return bob.toString();
    }

    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);

        final Injector injector = new Injector()
            .register(Scanner.class, scanner)
            .register(String[].class, args, "args");

        final List<RunConfig> methods = new ArrayList<>();

        // first, find any entrypoint method
        for (final Method method : FIRST_ENTRY.getDeclaredMethods()) {
            // check if the method is an entrypoint
            if (!method.isAnnotationPresent(Entrypoint.class)) {
                continue;
            }
            final Entrypoint entrypoint = method.getAnnotation(Entrypoint.class);
            final RunConfig config = new RunConfig(
                method, entrypoint, FIRST_ENTRY
            );
            methods.add(config);
        }

        // if no method was found, simply exit
        if (methods.size() == 0) {
            System.out.println("Error: cannot find entrypoint in class.");
            return;
        }

        // auto select first method if only one method exists in that class
        RunConfig config = getForcedConfig(methods);
        if (config == null && (config = select(scanner, methods)) == null) {
            System.out.println("Invalid run config.");
            return;
        }

        config.invoke(scanner, injector);
    }

}
