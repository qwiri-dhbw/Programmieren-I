package io.d2a.dhbw.klassen3;

import io.d2a.eeee.annotation.provider.EmptyAnnotationProvider;
import io.d2a.eeee.prompt.Wrappers;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    private final int m;
    private final int aus;

    private int[] tip;
    private int[] ziehung;

    public Lotto(final int m, final int n) {
        this.m = m;
        this.aus = n;
    }

    public int[] tippen() throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int[] tips = new int[this.m];
        for (int i = 0; i < m; i++) {
            while (true) {
                // get i-th tip
                tips[i] = Wrappers.requestValue(
                    scanner,
                    int.class,
                    String.format("Dein %d-ter Tipp", (i + 1)),
                    EmptyAnnotationProvider.DEFAULT
                );
                if (tips[i] <= 0 || tips[i] > this.aus) {
                    System.out.println("Ungueltiger Tipp.");
                } else {
                    break;
                }
            }
        }
        return tips;
    }

    public void tippen(int... numbers) {
        this.tip = numbers;
    }

    public void ziehen() {
        this.ziehung = new int[this.m];
        for (int i = 0; i < this.ziehung.length; i++) {
            this.ziehung[i] = new Random().nextInt(this.aus + 1) - 1;
        }
    }

    public int richtige() {
        int res = 0;
        for (int i = 0; i < this.ziehung.length; i++) {
            final int z = this.ziehung[i];
            final int t = this.tip[i];
            if (z == t) {
                res += 1;
            }
        }
        return res;
    }

    public int[] getZiehung() {
        return this.ziehung;
    }

}
