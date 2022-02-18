package io.d2a.dhbw.klassen3;

import java.util.stream.IntStream;

public class Nimmspiel {

    private final int[] haufen;
    private final String[] players;

    private int currentPlayer = 0;

    public Nimmspiel(final int[] haufen, final String[] players) {
        this.haufen = haufen;
        this.players = players;
    }

    public int nextPlayer() {
        return this.currentPlayer = (this.currentPlayer + 1) % this.players.length;
    }

    public String getCurrentPlayer() {
        return this.players[this.currentPlayer];
    }

    public boolean take(final int haufen, final int num) {
        final int val = this.haufen[haufen];
        if (val < num) {
            return false;
        }
        this.haufen[haufen] = val - num;
        return true;
    }

    public boolean empty() {
        return IntStream.of(this.haufen).sum() == 0;
    }

    public String toHaufenString() {
        final StringBuilder bob = new StringBuilder();
        for (int i = 0; i < this.haufen.length; i++) {
            if (this.haufen[i] == 0) {
                continue;
            }
            if (bob.length() > 0) {
                bob.append(", ");
            }
            bob.append("Haufen ").append(i).append(": ").append(this.haufen[i]);
        }
        return bob.toString();
    }

}
