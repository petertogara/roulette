package com.playsafe.roullette.controller.core.context.strategy.impl;

import com.playsafe.roullette.controller.core.context.strategy.api.Strategy;
import com.playsafe.roullette.entity.BetType;
import org.springframework.stereotype.Component;

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
