package io.d2a.dhbw.eeee;

import io.d2a.dhbw._20220214.Test;
import io.d2a.dhbw.eeee.annotations.Entrypoint;
import io.d2a.dhbw.eeee.annotations.ForceRun;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {

    public static final Class<?> FIRST_ENTRY = Test.class;

    public static void main(String[] args) throws Exception {
        int i = 0;
        final List<RunConfig> methods = new ArrayList<>();

        // first, find any entrypoint method
        for (final Method method : FIRST_ENTRY.getDeclaredMethods()) {
            // check if the method is an entrypoint
            if (!method.isAnnotationPresent(Entrypoint.class)) {
                continue;
            }
            final Entrypoint entrypoint = method.getAnnotation(Entrypoint.class);
            System.out.printf("%d. %s::%s@%s%n", ++i,
                FIRST_ENTRY.getSimpleName(), entrypoint.value(), method.getName());

            final RunConfig config = new RunConfig(
                method, entrypoint, FIRST_ENTRY
            );

            methods.add(config);
        }

        if (i == 0) {
            System.out.println("Error: cannot find entrypoint in class.");
            return;
        }

        final Scanner scanner = new Scanner(System.in);

        // auto select first method if only one method exists in that class
        RunConfig config = null;

        // check if there's an force method
        for (final RunConfig method : methods) {
            if (method.method.isAnnotationPresent(ForceRun.class)) {
                config = method;
                break;
            }
        }

        if (config == null) {
            if (i == 1) {
                config = methods.get(0);
            } else {
                System.out.print("Select Method to run [1-" + i + "]: ");

                int a;
                for (; ; ) {
                    try {
                        a = scanner.nextInt();
                        scanner.nextLine();
                        if (a < 1 || a > methods.size()) {
                            System.out.print("Please use a number in the valid range! > ");
                        }
                        break;
                    } catch (final NumberFormatException nfex) {
                        System.out.print("Please use only numbers! > ");
                    }
                }
                config = methods.get(a - 1);
            }
        }

        // get n-th number
        if (config == null) {
            System.out.println("Invalid run config.");
            return;
        }

        System.out.printf("Invoking method %s from class %s ...%n",
            config.method.getName(), config.clazz.getSimpleName());

        config.invoke(scanner);
    }

}
