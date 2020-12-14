package com.playsafe.roullette.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
@Data
public class PlayerResult {
    Player player;
    String bet;
    Result result;
    double bettingSum;
    double winnings;

}
