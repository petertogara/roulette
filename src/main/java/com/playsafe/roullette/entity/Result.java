package com.playsafe.roullette.entity;

public enum Result {
    WIN,
    LOSE;

    public static Result valueOf(final boolean hit) {
        return hit ? WIN : LOSE;
    }
}
