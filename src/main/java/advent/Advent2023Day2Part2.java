package advent;

import model.advent2023.day2.CubeSet;
import model.advent2023.day2.Game;
import model.advent2023.day2.GameFactory;
import utils.AdventUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Advent2023Day2Part2 implements AdventSolver {

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
            int answer = lines.stream()
                    .map(GameFactory::createGame)
                    .filter(Objects::nonNull)
                    .map(Game::getPower)
                    .reduce(Integer::sum).orElse(0);
            System.out.println(answer);
        }
    }
}
