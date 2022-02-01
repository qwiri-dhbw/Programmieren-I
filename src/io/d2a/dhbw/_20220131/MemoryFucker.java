package io.d2a.dhbw._20220131;

import java.math.BigInteger;

public class MemoryFucker {

    public static void main(String[] args) {
        final String value = new BigInteger("456").pow(12345678).toString();
        System.out.println(value);
        System.out.println("---");
        System.out.println("Laenge: " + value.length());
    }

}
