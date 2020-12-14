package com.playsafe.roullette.entity;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class PlayerBet {

    Player player;
    String bet;
    double sum;
}
