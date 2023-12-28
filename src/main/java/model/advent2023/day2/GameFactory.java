package model.advent2023.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameFactory {

    private static CubeSet getCubeSetFromString(String roundString) {
        CubeSet cubeSet = new CubeSet();
        Arrays.asList(roundString.split(","))
                .forEach(cubeString -> {
                    String[] parts = cubeString.trim().split(" ");
                    if (parts.length == 2) {
                        Integer quantity = Integer.parseInt(parts[0]);
                        String color = parts[1];
                        cubeSet.insertCubes(color, quantity);
                    }
                });
        return cubeSet;
    }

    private static List<CubeSet> getCubeRoundList(String roundSetString) {
        List<String> roundStrings = Arrays.asList(roundSetString.split(";"));
        return roundStrings.stream()
                .map(GameFactory::getCubeSetFromString)
                .collect(Collectors.toList());
    }

    public static Game createGame(String gameEntry) {
        String[] gameStrings = gameEntry.split(":");
        if (gameStrings.length == 2) {
            String gameIdString = gameStrings[0];
            String cubeRoundString = gameStrings[1];
            int gameId = Integer.parseInt(gameIdString.split(" ")[1]);
            List<CubeSet> cubeRounds = getCubeRoundList(cubeRoundString);
            return new Game(gameId, cubeRounds);
        } else {
            return null;
        }
    }
}
