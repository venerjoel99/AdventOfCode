package advent;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AdventSolverFactoryTest {
    @Test
    public void testAdventSolverFactory(){
        Assertions.assertInstanceOf(Advent2023Day1Part1.class, AdventSolverFactory.getAdventSolver(2023,1,1));
        Assertions.assertInstanceOf(Advent2023Day1Part2.class, AdventSolverFactory.getAdventSolver(2023,1,2));
        Assertions.assertInstanceOf(Advent2023Day2Part1.class, AdventSolverFactory.getAdventSolver(2023,2,1));
        Assertions.assertInstanceOf(Advent2023Day2Part2.class, AdventSolverFactory.getAdventSolver(2023,2,2));
        Assertions.assertInstanceOf(Advent2023Day2Part2.class, AdventSolverFactory.getAdventSolver(2023,2,2));
        Assertions.assertInstanceOf(Advent2023Day3Part1.class, AdventSolverFactory.getAdventSolver(2023,3,1));
        Assertions.assertInstanceOf(Advent2023Day4Part1.class, AdventSolverFactory.getAdventSolver(2023,4,1));
        Assertions.assertInstanceOf(Advent2023Day4Part2.class, AdventSolverFactory.getAdventSolver(2023,4,2));
    }
}