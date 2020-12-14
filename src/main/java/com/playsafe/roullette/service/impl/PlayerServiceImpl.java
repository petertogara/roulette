package com.playsafe.roullette.service.impl;

import com.playsafe.roullette.entity.Player;
import com.playsafe.roullette.entity.PlayerResult;
import com.playsafe.roullette.service.api.PlayerService;

import java.util.Collection;
import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {
    @Override
    public Collection<Player> getAll() {
        return null;
    }

    @Override
    public Optional<Player> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public void updateResults(Collection<PlayerResult> playerResults) {

    }
}
