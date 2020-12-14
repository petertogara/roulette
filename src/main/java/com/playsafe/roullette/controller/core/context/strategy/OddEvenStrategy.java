package com.playsafe.roullette.controller.core.context.strategy;

import com.playsafe.roullette.entity.BetType;
import com.playsafe.roullette.entity.OddEvenType;

@Component
public class OddEvenStrategy implements Strategy {

    @Override
    public boolean hit(final int number, final String bet) {
        OddEvenType betType = OddEvenType.lookup(bet);
        OddEvenType numberType = OddEvenType.lookup(number);
        return betType == numberType;
    }

    @Override
    public BetType getType() {
        return BetType.ODD_EVEN;
    }

}
