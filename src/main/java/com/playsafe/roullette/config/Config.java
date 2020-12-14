package com.playsafe.roullette.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@ComponentScan(basePackages = "com.playsafe.roullette")
@PropertySource("classpath:application.properties")
public class Config {

        @Bean
        public Random random() {
            return new Random();
        }

        @Bean
        public BufferedReader consoleReader() throws UnsupportedEncodingException {
            return new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }

    }
