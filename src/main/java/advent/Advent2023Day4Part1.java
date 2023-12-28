package advent;

import model.advent2023.day3.Board;
import model.advent2023.day3.NumberSolver;
import model.advent2023.day4.Card;
import model.advent2023.day4.CardFactory;
import utils.AdventUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Advent2023Day4Part1 implements AdventSolver {

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
            Integer getTotalScore =
                    lines.stream()
                            .map(CardFactory::getCardFromLine)
                            .map(Card::getCardScore)
                            .reduce(Integer::sum)
                            .orElse(0);
            System.out.println(getTotalScore);
        }
    }
}
