package com.playsafe.roullette;


public class RoulletteApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RouletteGameConfiguration.class);
        RouletteGameStarter rouletteGameStarter = applicationContext.getBean(RouletteGameStarter.class);
        rouletteGameStarter.start();
    }
}
