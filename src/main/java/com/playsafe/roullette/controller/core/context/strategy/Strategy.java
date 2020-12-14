package com.playsafe.roullette.controller.core.context.strategy;

import com.playsafe.roullette.entity.BetType;
import com.playsafe.roullette.entity.Result;

public interface Strategy {

    default Result getResult(int number, String bet) {
        return Result.valueOf(hit(number, bet));
    }

    boolean hit(int number, String bet);

    BetType getType();

}
