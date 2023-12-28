package advent;

import model.advent2023.day1.Calibration;

public class Advent2023Day1Part2 extends Advent2023Day1Part1{

    @Override
    public void solve() {
        if (exceptionHit) {
            System.out.println("Could not solve the problem");
        }
        else if (lines == null) {
            System.out.println("No lines read from the file");
        }
        else {
            int calibrationValue = Calibration.getCalibrationSumFromLinesWithWordDigits(lines);
            System.out.println(calibrationValue);
        }
    }
}
