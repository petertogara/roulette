package com.playsafe.roullette;

import com.playsafe.roullette.config.Config;
import com.playsafe.roullette.controller.GameEntry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class RoulletteApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        GameEntry gameEntry= context.getBean(GameEntry.class);
        gameEntry.start();
    }
}
