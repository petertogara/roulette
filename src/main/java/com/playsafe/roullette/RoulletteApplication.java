package com.playsafe.roullette;

import com.playsafe.roullette.config.Config;
import com.playsafe.roullette.controller.GameEntry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RoulletteApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        GameEntry rouletteGameStarter = context.getBean(GameEntry.class);
        rouletteGameStarter.start();
    }
}
