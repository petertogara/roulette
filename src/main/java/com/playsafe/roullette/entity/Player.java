package com.playsafe.roullette.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Player {
    private String name;
    private Double totalBet;
    private Double totalWin;

    public Player(String name, double bettingSum, double winnings) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalBet() {
        return totalBet;
    }

    public void setTotalBet(Double totalBet) {
        this.totalBet = totalBet;
    }

    public Double getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(Double totalWin) {
        this.totalWin = totalWin;
    }

    public Player(final String name) {
        this.name = name;
    }

    public static Player from(final PlayerResult playerResult) {
        return new Player(
                playerResult.getPlayer().getName(),
                playerResult.getBettingSum(),
                playerResult.getWinnings());
    }
}
