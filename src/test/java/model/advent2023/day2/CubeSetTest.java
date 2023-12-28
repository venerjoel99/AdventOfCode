package model.advent2023.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CubeSetTest {

    @Test
    void testInsertCubes() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.insertCubes("blue", 3);
        Assertions.assertEquals(3, cubeSet.getNumberOfCubes("blue"));
    }

    @Test
    void testInsertCubesTwoTimes() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.insertCubes("blue", 3);
        cubeSet.insertCubes("blue", 4);
        Assertions.assertEquals(7, cubeSet.getNumberOfCubes("blue"));
    }

    @Test
    void testInsertCubesThreeTimes() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.insertCubes("blue", 3);
        cubeSet.insertCubes("blue", 4);
        cubeSet.insertCubes("green", 5);
        Assertions.assertEquals(7, cubeSet.getNumberOfCubes("blue"));
        Assertions.assertEquals(5, cubeSet.getNumberOfCubes("green"));
        Assertions.assertEquals(0, cubeSet.getNumberOfCubes("red"));
    }

    @Test
    void testInsertCubesThreeTimesWithNegative() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.insertCubes("blue", 3);
        cubeSet.insertCubes("blue", 4);
        cubeSet.insertCubes("blue", -9);
        cubeSet.insertCubes("green", 5);
        Assertions.assertEquals(7, cubeSet.getNumberOfCubes("blue"));
        Assertions.assertEquals(5, cubeSet.getNumberOfCubes("green"));
        Assertions.assertEquals(0, cubeSet.getNumberOfCubes("red"));
    }

    @Test
    void testGetNumberOfCubes() {
        CubeSet cubeSet = new CubeSet();
        Assertions.assertEquals(0, cubeSet.getNumberOfCubes("blue"));
    }

    @Test
    void testIsSubsetOf() {
        CubeSet cubeSubSet = new CubeSet();
        cubeSubSet.insertCubes("blue", 3);
        cubeSubSet.insertCubes("green", 4);
        cubeSubSet.insertCubes("red", 5);
        CubeSet cubeSuperSet = new CubeSet();
        cubeSuperSet.insertCubes("blue", 7);
        cubeSuperSet.insertCubes("green", 8);
        cubeSuperSet.insertCubes("red", 9);
        Assertions.assertTrue(cubeSubSet.isSubSetOf(cubeSuperSet));
    }

    @Test
    void testIsSubsetOfFalse() {
        CubeSet cubeSubSet = new CubeSet();
        cubeSubSet.insertCubes("blue", 3);
        cubeSubSet.insertCubes("green", 10);
        cubeSubSet.insertCubes("red", 5);
        CubeSet cubeSuperSet = new CubeSet();
        cubeSuperSet.insertCubes("blue", 7);
        cubeSuperSet.insertCubes("green", 8);
        cubeSuperSet.insertCubes("red", 9);
        Assertions.assertFalse(cubeSubSet.isSubSetOf(cubeSuperSet));
    }

    @Test
    void testIsSubsetOfMissingKey() {
        CubeSet cubeSubSet = new CubeSet();
        cubeSubSet.insertCubes("blue", 3);
        cubeSubSet.insertCubes("green", 10);
        cubeSubSet.insertCubes("red", 5);
        CubeSet cubeSuperSet = new CubeSet();
        cubeSuperSet.insertCubes("blue", 7);
        cubeSuperSet.insertCubes("red", 9);
        Assertions.assertFalse(cubeSubSet.isSubSetOf(cubeSuperSet));
    }

    @Test
    void testIsSubsetOfEmptySet() {
        CubeSet cubeSubSet = new CubeSet();
        CubeSet cubeSuperSet = new CubeSet();
        cubeSuperSet.insertCubes("blue", 7);
        cubeSuperSet.insertCubes("red", 9);
        Assertions.assertTrue(cubeSubSet.isSubSetOf(cubeSuperSet));
    }

    @Test
    void testGetPower() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.insertCubes("blue", 3);
        cubeSet.insertCubes("green", 4);
        cubeSet.insertCubes("red", 5);
        Assertions.assertEquals(60, cubeSet.getPower());
    }

    @Test
    void testReplaceWithNewQuantityIfGreater() {
        CubeSet cubeSet = new CubeSet();
        CubeSet otherCubeSet = new CubeSet();
        cubeSet.insertCubes("blue", 3);
        cubeSet.insertCubes("green", 6);
        otherCubeSet.insertCubes("blue", 5);
        otherCubeSet.insertCubes("green", 4);
        cubeSet.replaceWithOtherCubeSetGreaterQuantities(otherCubeSet);
        Assertions.assertEquals(5, cubeSet.getNumberOfCubes("blue"));
        Assertions.assertEquals(6, cubeSet.getNumberOfCubes("green"));
    }
}