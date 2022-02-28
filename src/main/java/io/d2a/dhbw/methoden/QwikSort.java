package io.d2a.dhbw.methoden;

import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.Entrypoint;
import io.d2a.eeee.annotation.annotations.Fill;
import io.d2a.eeee.annotation.annotations.ForceRun;
import io.d2a.eeee.annotation.annotations.Generate;
import io.d2a.eeee.annotation.annotations.Range;
import io.d2a.eeee.inject.Inject;
import java.util.Arrays;
import java.util.Scanner;

public class QwikSort {

    public static void main(final String[] args) throws Exception {
        Starter.byCaller();
    }

    @Entrypoint
    public void run(
        @Generate @Fill(10) int[] numbersA,
        @Generate @Range({0, 100, 10}) @Fill(10) int[] numbersB
    ) {
        System.out.println(Arrays.toString(numbersA));
        System.out.println(Arrays.toString(numbersB));
    }

    @Entrypoint @ForceRun
    public void run(
        @Inject final Scanner scanner
    ) {
        System.out.println(scanner.nextLine());
    }

    private static void pivot(int[] array, final int pivotIndex) {
        for (int i = 0; i < array.length; i++) {

        }
    }

    public static void sort(int[] array) {

    }

}
