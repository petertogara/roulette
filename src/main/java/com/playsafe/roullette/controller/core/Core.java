package com.playsafe.roullette.controller.core;


import com.playsafe.roullette.controller.core.context.GameContext;
import com.playsafe.roullette.entity.PlayerBet;
import com.playsafe.roullette.entity.RoundResult;
import com.playsafe.roullette.service.api.PlayerService;
import com.playsafe.roullette.utils.Printer;
import lombok.Value;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Core {

    private final InputReader inputReader;
    private final Printer printer;
    private final long roundCooldown;
    private final GameContext gameContext;
    private final PlayerService playerService;
    private final AtomicInteger roundCounter;
    private final AtomicBoolean isActive;

    public Core(InputReader inputReader,
                      Printer printer,
                      GameContext gameContext,
                      PlayerService playerService,
                      @Value("${round.cooldownMs}") long roundCooldown) {
        this.inputReader = inputReader;
        this.printer = printer;
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
                printer.printThxForBet();
            } catch (Exception ex) {
                printer.printUserBetException(ex.getMessage());
            }
        }
    }

    public void stopGame() {
        isActive.set(false);
    }

    private void startRoundTimer() {
        RoundInit();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finishRound();
            }
        }, roundCooldown, roundCooldown);
    }

    private void finishRound() {
        RoundResult roundResult = gameContext.finishRound();
        printer.printRoundResult(roundCounter.intValue(), roundResult);
        playerService.updateResults(roundResult.getPlayerResults());
        printer.printPlayers();
        RoundInit();
    }

    private void RoundInit() {
        roundCounter.incrementAndGet();
        printer.printStartRoundMessage(roundCounter.intValue());
    }
}
