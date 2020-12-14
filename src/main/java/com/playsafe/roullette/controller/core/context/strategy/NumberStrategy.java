package com.playsafe.roullette.controller.core.context.strategy;

import com.playsafe.roullette.entity.BetType;

import static com.playsafe.roullette.entity.BetType.NUMBER;

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
