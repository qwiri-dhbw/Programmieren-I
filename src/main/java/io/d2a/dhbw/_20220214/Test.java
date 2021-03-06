package io.d2a.dhbw._20220214;

import io.d2a.dhbw._20220214.clazz.Account;
import io.d2a.dhbw._20220214.clazz.Point;
import io.d2a.dhbw._20220214.clazz.Radio;
import io.d2a.eeee.Starter;
import io.d2a.eeee.annotation.annotations.prompt.Default;
import io.d2a.eeee.annotation.annotations.prompt.Entrypoint;
import io.d2a.eeee.annotation.annotations.prompt.Prompt;
import io.d2a.eeee.annotation.annotations.common.Range;
import io.d2a.eeee.inject.Inject;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {
        Starter.start(Test.class, args);
    }

    @Inject
    private Scanner scanner;

    @Inject("args")
    private String[] args;

    @Entrypoint("Radio")
    public void testRadio() {
        final Radio radio = new Radio(false, 7, 95.3f);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8f);
        System.out.println(radio);
        radio.setFrequency(112.7f);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }

    @Entrypoint("Point")
    public void testPoint() {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
            + pointA.distance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
            + pointA.distance(pointB));
    }

    @Entrypoint("Account")
    public void testAccount(
        @Prompt("Startguthaben") @Range({1, 1000}) @Default("5000") int start,
        @Prompt("Accountinhaber") @Default("daniel") String name
    ) {
        Account account = new Account(
            4711, name, (short) start, (short) 1000.0
        );

        System.out.println(account);
        account.processDeposit((short) 200);
        System.out.println(account);
        account.processPayment((short) 400);
        System.out.println(account);
        account.processPayment((short) 2000);
        System.out.println(account);
    }

    @Entrypoint("echo")
    public void runEcho() {
        final String input = this.scanner.nextLine();
        System.out.println("Echo! " + input);
    }

}
