package com.playsafe.roullette.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private Double totalBet;
    private Double totalWin;

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
