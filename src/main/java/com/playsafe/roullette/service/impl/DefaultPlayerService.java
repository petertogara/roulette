package com.playsafe.roullette.service.impl;


import com.playsafe.roullette.entity.Player;
import com.playsafe.roullette.entity.PlayerResult;
import com.playsafe.roullette.repository.api.PlayerRepository;
import com.playsafe.roullette.service.api.PlayerService;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

@Component
public class DefaultPlayerService implements PlayerService {

    private final Map<String, Player> playersMap;

    public DefaultPlayerService(PlayerRepository playerRepository) throws IOException {
        this.playersMap = playerRepository.findAll().stream()
                .collect(toMap(Player::getName, identity()));
    }

    @Override
    public Collection<Player> getAll() {
        return playersMap.values();
    }

    @Override
    public Optional<Player> getByName(String name) {
        return ofNullable(playersMap.get(name));
    }

    @Override
    public void updateResults(final Collection<PlayerResult> playerResults) {
        playerResults.forEach(this::updatePlayer);
    }

    private void updatePlayer(PlayerResult playerResult) {
        Player player = playersMap.get(playerResult.getPlayer().getName());
        player.setTotalBet(player.getTotalBet() + playerResult.getBettingSum());
        player.setTotalWin(player.getTotalWin() + playerResult.getWinnings());
    }
}
