package model.advent2023.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NumberSolverTest {
    @Test
    void testGetTotalValue() {
        List<String> boardStrings = new ArrayList<>();
        boardStrings.add(".:23433..3");
        boardStrings.add(".55......7");
        Board board = new Board(boardStrings);
        NumberSolver numberSolver = new NumberSolver(board.getNumberGroups(), board);
        Assertions.assertEquals(23488, numberSolver.getTotalValue());
    }

    @Test
    void testGetTotalPower() {
        List<String> boardStrings = new ArrayList<>();
        boardStrings.add(".*10....4*");
        boardStrings.add(".50..4*..5");
        Board board = new Board(boardStrings);
        NumberSolver numberSolver = new NumberSolver(board.getNumberGroups(), board);
        Assertions.assertEquals(520, numberSolver.getTotalPower());
    }
}