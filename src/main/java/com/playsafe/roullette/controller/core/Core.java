package com.playsafe.roullette.controller.core;


import com.playsafe.roullette.controller.core.context.GameContext;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class Core {

    private final InputReader inputReader;
    private final ConsolePrinter consolePrinter;
    private final long roundCooldown;
    private final GameContext gameContext;
    private final PlayerService playerService;
    private final AtomicInteger roundCounter;
    private final AtomicBoolean isActive;

    public Core(InputReader inputReader,
                      ConsolePrinter consolePrinter,
                      GameContext gameContext,
                      PlayerService playerService,
                      @Value("${round.cooldownMs}") long roundCooldown) {
        this.inputReader = inputReader;
        this.consolePrinter = consolePrinter;
        this.roundCooldown = roundCooldown;
        this.gameContext = gameContext;
        this.playerService = playerService;
        this.roundCounter = new AtomicInteger(0);
        this.isActive = new AtomicBoolean(true);
    }

    public void init() {
        startRoundTimer();
        while (isActive.get()) {
            try {
                PlayerBet playerBet = inputReader.readBet();
                gameContext.bet(playerBet);
                consolePrinter.printThxForBet();
            } catch (Exception ex) {
                consolePrinter.printUserBetException(ex.getMessage());
            }
        }
    }

    public void stopGame() {
        isActive.set(false);
    }

    private void startRoundTimer() {
        startRound();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finishRound();
            }
        }, roundCooldown, roundCooldown);
    }

    private void finishRound() {
        RoundResult roundResult = gameContext.finishRound();
        consolePrinter.printRoundResult(roundCounter.intValue(), roundResult);
        playerService.updateResults(roundResult.getPlayerResults());
        consolePrinter.printPlayers();
        startRound();
    }

    private void startRound() {
        roundCounter.incrementAndGet();
        consolePrinter.printStartRoundMessage(roundCounter.intValue());
    }
}
