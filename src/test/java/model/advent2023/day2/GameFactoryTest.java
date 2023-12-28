package model.advent2023.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameFactoryTest {

    @Test
    void testCreateGame() {
        String gameString = "Game 11: 4 green, 2 blue; 1 red, 1 blue, 4 green";
        Game game = GameFactory.createGame(gameString);
        Assertions.assertNotNull(game);
        Assertions.assertNotNull(game.getCubeSetList());
        Assertions.assertEquals(11, game.getGameId());
        Assertions.assertEquals(2, game.getCubeSetList().size());
        CubeSet firstSet = game.getCubeSetList().get(0);
        CubeSet secondSet = game.getCubeSetList().get(1);
        Assertions.assertEquals(4, firstSet.getNumberOfCubes("green"));
        Assertions.assertEquals(2, firstSet.getNumberOfCubes("blue"));
        Assertions.assertEquals(1, secondSet.getNumberOfCubes("red"));
        Assertions.assertEquals(1, secondSet.getNumberOfCubes("blue"));
        Assertions.assertEquals(4, secondSet.getNumberOfCubes("green"));
    }
}