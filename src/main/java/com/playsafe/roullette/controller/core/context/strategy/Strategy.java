package com.playsafe.roullette.controller.core.context.strategy;

public interface Strategy {

    default Outcome getOutcome(int number, String bet) {
        return Outcome.valueOf(hit(number, bet));
    }

    boolean hit(int number, String bet);

    BetType getType();

}
