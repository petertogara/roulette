package com.playsafe.roullette.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerResult {
    Player player;
    String bet;
    Result result;
    double bettingSum;
    double winnings;

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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public double getBettingSum() {
        return bettingSum;
    }

    public void setBettingSum(double bettingSum) {
        this.bettingSum = bettingSum;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }
}
