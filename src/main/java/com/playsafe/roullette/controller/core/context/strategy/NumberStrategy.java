package com.playsafe.roullette.controller.core.context.strategy;

@Component
public class NumberStrategy implements Strategy {

    @Override
    public boolean hit(final int number, final String bet) {
        return number == Integer.parseInt(bet);
    }

    @Override
    public BetType getType() {
        return NUMBER;
    }
}
