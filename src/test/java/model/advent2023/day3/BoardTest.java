package model.advent2023.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        List<String> boardStrings = new ArrayList<>();
        boardStrings.add("..23433.#3");
        boardStrings.add("*55......7");
        board = new Board(boardStrings);
    }

    @Test
    void testGetNumberGroups() {
        List<NumberGroup> numberGroups = board.getNumberGroups();
        Assertions.assertEquals(4, numberGroups.size());
        Assertions.assertEquals(23433, numberGroups.get(0).getValue());
        Assertions.assertEquals(3, numberGroups.get(1).getValue());
        Assertions.assertEquals(55, numberGroups.get(2).getValue());
        Assertions.assertEquals(7, numberGroups.get(3).getValue());
    }

    @Test
    void testIsSymbol() {
        Assertions.assertTrue(board.isSymbol(0,8));
        Assertions.assertFalse(board.isSymbol(0,0));
        Assertions.assertFalse(board.isSymbol(1,1));
    }

    @Test
    void testIsGear() {
        Assertions.assertTrue(board.isGear(1,0));
        Assertions.assertFalse(board.isGear(0,0));
        Assertions.assertFalse(board.isSymbol(1,1));
    }
}