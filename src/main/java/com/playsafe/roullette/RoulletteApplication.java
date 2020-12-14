package com.playsafe.roullette;

import com.playsafe.roullette.config.Config;
import com.playsafe.roullette.controller.GameEntry;

public class RoulletteApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        GameEntry gameEntry= context.getBean(GameEntry.class);
        gameEntry.start();
    }
}
