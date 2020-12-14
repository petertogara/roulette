package com.playsafe.roullette.controller.reader;

import com.playsafe.roullette.entity.PlayerBet;

import java.io.IOException;

public interface InputReader {

    PlayerBet readBet() throws IOException;

    void waitAnyInput() throws IOException;
}
