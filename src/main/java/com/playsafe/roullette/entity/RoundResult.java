package com.playsafe.roullette.entity;

import lombok.Value;

import java.util.Collection;

public class RoundResult {
    int number;
    Collection<PlayerResult> playerResults;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Collection<PlayerResult> getPlayerResults() {
        return playerResults;
    }

    public void setPlayerResults(Collection<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public RoundResult(int number, Collection<PlayerResult> playerResults) {
        this.number = number;
        this.playerResults = playerResults;
    }
}
