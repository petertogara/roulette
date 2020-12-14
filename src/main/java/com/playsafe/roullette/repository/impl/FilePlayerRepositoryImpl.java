package com.playsafe.roullette.repository.impl;


import com.playsafe.roullette.entity.Player;
import com.playsafe.roullette.repository.api.PlayerRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static com.playsafe.roullette.utils.File.loadClassPathFileContent;
import static com.playsafe.roullette.utils.File.loadFileContent;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Component
public class FilePlayerRepositoryImpl implements PlayerRepository {

    private static final String PLAYERS_FILE_PATH_PROPERTY_NAME = "players.file.path";
    private static final String PLAYERS_FILE_NAME = "players.csv";
    private static final String SPLITERATOR = ",";

    @Override
    public List<Player> findAll() throws IOException {
        try (Stream<String> stream = getPlayersStream()) {
            return stream.map(this::toPlayer)
                    .collect(toList());
        }
    }

    private Stream<String> getPlayersStream() throws IOException {
        String customPropertiesFilePth = System.getProperties().getProperty(PLAYERS_FILE_PATH_PROPERTY_NAME);
        if (isNotBlank(customPropertiesFilePth)) {
            System.out.println(format("Loading custom players from [%s]...", customPropertiesFilePth));
            return loadFileContent(customPropertiesFilePth);
        } else {
            System.out.println("Loading default players...");
            return loadClassPathFileContent(PLAYERS_FILE_NAME);
        }
    }

    private Player toPlayer(String line) {
        String[] values = line.split(SPLITERATOR, -1);
        String playerName = values[0];
        double totalBet = getDouble(values[1]);
        double totalWin = getDouble(values[2]);
        return new Player(playerName, totalBet, totalWin);
    }

    private double getDouble(final String value) {
        return isBlank(value) ? 0 : Double.valueOf(value);
    }
}
