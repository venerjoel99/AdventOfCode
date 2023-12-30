package advent;

import model.advent2023.day4.Card;
import model.advent2023.day4.CardFactory;
import utils.AdventUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Advent2023Day4Part2 implements AdventSolver {

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
            int numberOfCards = lines.size();
            lines.forEach(CardFactory::getCardFromLine);
            IntStream.range(1, numberOfCards + 1)
                .forEach(id -> {
                    Card card = CardFactory.getCardById(id);
                    int matches = card.getNumberOfMatches();
                    int numberOfCopies = card.getCopies();
                    IntStream.range(id + 1, id + matches + 1)
                            .forEach(subId -> CardFactory.getCardById(subId).increaseCopies(numberOfCopies));
                });
            Integer answer = IntStream.range(1, numberOfCards + 1)
                    .map(id -> CardFactory.getCardById(id).getCopies())
                    .reduce(Integer::sum)
                    .orElse(0);
            System.out.println(answer);
        }
    }
}
