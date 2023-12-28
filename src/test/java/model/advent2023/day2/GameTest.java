package model.advent2023.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class GameTest {

    @Test
    void testIsGamePossible() {
        List<CubeSet> cubeSetList = new ArrayList<>();
        CubeSet cubeSet1 = Mockito.mock(CubeSet.class);
        CubeSet cubeSet2 = Mockito.mock(CubeSet.class);
        CubeSet inventory = Mockito.mock(CubeSet.class);
        cubeSetList.add(cubeSet1);
        cubeSetList.add(cubeSet2);
        Mockito.when(cubeSet1.isSubSetOf(inventory)).thenReturn(true);
        Mockito.when(cubeSet2.isSubSetOf(inventory)).thenReturn(true);
        Game game = new Game(200, cubeSetList);
        Assertions.assertTrue(game.isGamePossible(inventory));
    }

    @Test
    void testIsGamePossibleOneGameFalse() {
        List<CubeSet> cubeSetList = new ArrayList<>();
        CubeSet cubeSet1 = Mockito.mock(CubeSet.class);
        CubeSet cubeSet2 = Mockito.mock(CubeSet.class);
        CubeSet inventory = Mockito.mock(CubeSet.class);
        cubeSetList.add(cubeSet1);
        cubeSetList.add(cubeSet2);
        Mockito.when(cubeSet1.isSubSetOf(inventory)).thenReturn(true);
        Mockito.when(cubeSet2.isSubSetOf(inventory)).thenReturn(false);
        Game game = new Game(200, cubeSetList);
        Assertions.assertFalse(game.isGamePossible(inventory));
    }

    @Test
    void testIsGamePossibleNoGame() {
        List<CubeSet> cubeSetList = new ArrayList<>();
        CubeSet inventory = Mockito.mock(CubeSet.class);
        Game game = new Game(200, cubeSetList);
        Assertions.assertTrue(game.isGamePossible(inventory));
    }

    @Test
    void testGetGameId() {
        Game game = new Game(200, null);
        Assertions.assertEquals(200, game.getGameId());
    }

    @Test
    void testGetPower() {
        CubeSet cubeSet1 = new CubeSet();
        CubeSet cubeSet2 = new CubeSet();
        cubeSet1.insertCubes("blue", 3);
        cubeSet1.insertCubes("green", 5);
        cubeSet2.insertCubes("blue", 7);
        cubeSet2.insertCubes("green", 4);
        List<CubeSet> cubeSetList = new ArrayList<>();
        cubeSetList.add(cubeSet1);
        cubeSetList.add(cubeSet2);
        Game game = new Game(200, cubeSetList);
        Assertions.assertEquals(35, game.getPower());
    }
}