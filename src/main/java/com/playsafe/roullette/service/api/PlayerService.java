package com.playsafe.roullette.service.api;

import com.playsafe.roullette.entity.Player;
import com.playsafe.roullette.entity.PlayerResult;

import java.util.Collection;
import java.util.Optional;

public interface PlayerService {

    Collection<Player> getAll();

    Optional<Player> getByName(String name);

    void updateResults(Collection<PlayerResult> playerResults);
}
