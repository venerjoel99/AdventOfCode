package advent;

import model.advent2023.day1.Calibration;
import utils.AdventUtils;

import java.io.*;
import java.util.List;

public class Advent2023Day1Part1 implements AdventSolver{
    List<String> lines;
    boolean exceptionHit = false;

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
        else if (lines == null) {
            System.out.println("No lines read from the file");
        }
        else {
            int calibrationValue = Calibration.getCalibrationSumFromLines(lines);
            System.out.println(calibrationValue);
        }
    }
}
