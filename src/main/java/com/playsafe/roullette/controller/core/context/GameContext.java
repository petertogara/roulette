package com.playsafe.roullette.controller.core.context;


import com.playsafe.roullette.entity.PlayerBet;
import com.playsafe.roullette.entity.PlayerResult;
import com.playsafe.roullette.entity.RoundResult;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class GameContext {

    private static final int NUMBER_BOUND = 36;

    private final Random random;
    private final GameResultClaculator gameResultCalculator;
    private Collection<PlayerBet> activeBets;

    public GameContext(final Random random, final GameResultClaculator gameResultCalculator) {
        this.random = random;
        this.gameResultCalculator = gameResultCalculator;
        resetActiveBets();
    }

    public void bet(PlayerBet playerBet) {
        activeBets.add(playerBet);
    }

    public RoundResult finishRound() {
        Collection<PlayerBet> playerBets = swapActiveBets();
        int randomNumber = random.nextInt(NUMBER_BOUND) + 1;
        List<PlayerResult> playerResults = gameResultCalculator.calculate(randomNumber, playerBets);
        return new RoundResult(randomNumber, playerResults);
    }

    private Collection<PlayerBet> swapActiveBets() {
        Collection<PlayerBet> playerBetsToProcess = activeBets;
        resetActiveBets();
        return playerBetsToProcess;
    }

    private void resetActiveBets() {
        activeBets = new ConcurrentLinkedQueue<>();
    }
}
