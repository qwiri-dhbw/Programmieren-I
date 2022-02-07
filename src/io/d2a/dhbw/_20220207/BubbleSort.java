package io.d2a.dhbw._20220207;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        final int[] array = E.requestArray();
        System.out.println(Arrays.toString(array));

        boolean swaped = false;
        do {
            for (int i = 0; i < array.length -1; i++) {
                if (array[i] > array[i + 1]) {
                    final int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swaped = true;
                }
            }
        } while (!swaped);

        System.out.println(Arrays.toString(array));
    }

}
