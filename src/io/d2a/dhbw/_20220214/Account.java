package io.d2a.dhbw._20220214;

public class Account {

    private static int kontoNrAuto = 0;

    private int kontoNr = kontoNrAuto++;
    private String holder;
    private short balance;
    private short limit;

    public Account(final int kontoNr, final String holder, final short balance, final short limit) {
        this(holder, balance, limit);
        this.kontoNr = kontoNr;
    }

    public Account(final String holder, final short balance, final short limit) {
        this(holder, balance);
        this.limit = limit;
    }

    public Account(final String holder, final short balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public void processDeposit(final short inp) {
        this.balance += inp;
    }

    public void processPayment(final short out) {
        this.balance -= out;
        if (this.balance < -this.limit) {
            System.out.println("Deckung nicht ausreichend!");
            this.balance += out;
        }
    }

    public short getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
            "kontoNr=" + kontoNr +
            ", holder='" + holder + '\'' +
            ", balance=" + balance + " Mio Euro" +
            ", limit=" + limit + " Mio Euro" +
            '}';
    }
}
