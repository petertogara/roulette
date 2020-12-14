package com.playsafe.roullette.controller;

import com.playsafe.roullette.controller.core.Core;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GameEntry {


    private final InputReader inputReader;
    private final ConsolePrinter consolePrinter;
    private final Core core;

    public void start() {
        consolePrinter.printBanner();
        consolePrinter.printRules();
        waitPlayerToContinue("load players");
        consolePrinter.printPlayers();
        waitPlayerToContinue("start the game");
        core.init();
    }

    private void waitPlayerToContinue(String action) {
        System.out.println(format("Enter any key to %s...", action));
        inputReader.waitAnyInput();
    }
}
