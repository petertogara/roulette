package com.playsafe.roullette.repository.api;

import com.playsafe.roullette.entity.Player;

import java.io.IOException;
import java.util.List;

public interface PlayerRepository {
    List<Player> findAll() throws IOException;
}
