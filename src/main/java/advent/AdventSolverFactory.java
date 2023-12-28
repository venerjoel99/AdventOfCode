package advent;

import java.util.Map;

public class AdventSolverFactory {

    private static final Map<String, AdventSolver> classMap =
            Map.of("2023_1_1", new Advent2023Day1Part1(),
                   "2023_1_2", new Advent2023Day1Part2(),
                   "2023_2_1", new Advent2023Day2Part1(),
                   "2023_2_2", new Advent2023Day2Part2(),
                   "2023_3_1", new Advent2023Day3Part1(),
                   "2023_3_2", new Advent2023Day3Part2(),
                   "2023_4_1", new Advent2023Day4Part1(),
                   "2023_4_2", new Advent2023Day4Part2());

    public static String buildString(int year, int day, int part) {
        return String.format("%d_%d_%d", year, day, part);
    }

    public static AdventSolver getAdventSolver(int year, int day, int part) {
        return classMap.get(buildString(year, day, part));
    }
}
