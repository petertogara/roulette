package com.playsafe.roullette.entity;


public class PlayerBet {

    Player player;
    String bet;
    double sum;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public PlayerBet(Player player, String bet, double sum) {
        this.player = player;
        this.bet = bet;
        this.sum = sum;
    }
}
