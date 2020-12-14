package com.playsafe.roullette.controller;

import com.playsafe.roullette.controller.core.Core;
import com.playsafe.roullette.controller.reader.InputReader;
import com.playsafe.roullette.utils.Printer;
import lombok.AllArgsConstructor;

import java.io.IOException;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class GameEntry {


    private final InputReader inputReader;
    private final Printer printer;
    private final Core core;

    public GameEntry(InputReader inputReader, Printer printer, Core core) {
        this.inputReader = inputReader;
        this.printer = printer;
        this.core = core;
    }

    public void start() throws IOException {
        printer.printBanner();
        printer.printRules();
        waitPlayerToContinue("load players");
        printer.printPlayers();
        waitPlayerToContinue("start the game");
        core.init();
    }

    private void waitPlayerToContinue(String action) {
        System.out.println(format("Enter any key to %s...", action));
        inputReader.waitAnyInput();
    }
}
