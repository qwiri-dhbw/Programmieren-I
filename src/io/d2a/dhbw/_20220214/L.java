package io.d2a.dhbw._20220214;

import io.d2a.dhbw.eeee.annotations.Default;
import io.d2a.dhbw.eeee.annotations.Entrypoint;
import io.d2a.dhbw.eeee.annotations.ForceRun;
import io.d2a.dhbw.eeee.annotations.parameters.Prompt;
import io.d2a.dhbw.eeee.annotations.parameters.number.Max;
import io.d2a.dhbw.eeee.annotations.parameters.number.Min;
import io.d2a.dhbw.eeee.inject.Inject;
import java.util.Scanner;

public class L {

    @Inject("args")
    private String[] args;

    @Inject
    private Scanner scanner;

    @Entrypoint
    public void run(
        @Prompt("name") @Default("Tobias") String name,
        @Prompt("Alter?") @Min(0) @Max(12) int age
    ) {
        System.out.printf("Age %d from %s is just a number%n", age, name);

        String a = this.scanner.nextLine();
        System.out.println("echo! " + a + " scanner: " + scanner);
    }

    @ForceRun
    @Entrypoint("Test XYZ")
    public void testA(boolean a) {
        System.out.println("ok cool! " + a);
    }

}
