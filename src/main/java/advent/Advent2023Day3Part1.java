package advent;

import model.advent2023.day2.Game;
import model.advent2023.day2.GameFactory;
import model.advent2023.day3.Board;
import model.advent2023.day3.NumberSolver;
import utils.AdventUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Advent2023Day3Part1 implements AdventSolver {

    private boolean exceptionHit;
    private List<String> lines;
    @Override
    public void loadInput(String inputFileName) {
        try {
            lines = AdventUtils.readLinesFromResourceFiles(inputFileName);
        } catch (IOException ioException) {
            System.out.println("ERROR LOADING THE FILE");
            System.out.println(ioException.getMessage());
            exceptionHit = true;
        }
    }

    @Override
    public void solve() {
        if (exceptionHit) {
            System.out.println("Could not solve the problem");
        }
        else {
            Board board = new Board(lines);
            NumberSolver numberSolver = new NumberSolver(board.getNumberGroups(), board);
            System.out.println(numberSolver.getTotalValue());
        }
    }
}
