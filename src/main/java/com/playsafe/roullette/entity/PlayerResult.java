package com.playsafe.roullette.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerResult {
    Player player;
    String bet;
    Result result;
    double bettingSum;
    double winnings;
}
