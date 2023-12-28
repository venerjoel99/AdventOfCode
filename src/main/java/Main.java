import advent.AdventSolver;
import advent.AdventSolverFactory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        // Get Advent class
        AdventSolver adventSolver = AdventSolverFactory.getAdventSolver(2023, 3, 2);
        // Load input
        adventSolver.loadInput("input.txt");
        // Run the program
        adventSolver.solve();
    }
}