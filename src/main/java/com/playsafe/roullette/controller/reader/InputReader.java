package com.playsafe.roullette.controller.reader;

import com.playsafe.roullette.entity.PlayerBet;

public interface InputReader {

    PlayerBet readBet();

    void waitAnyInput();
}
