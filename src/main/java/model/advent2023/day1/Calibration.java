package model.advent2023.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calibration {

    private static final String[] digits = {
            "0","1","2","3","4","5","6","7","8","9","zero","one","two","three","four","five","six","seven","eight","nine",
    };
    private final String calibrationInput;

    public Calibration(String calibrationInput) {
        this.calibrationInput = calibrationInput;
    }

    public int getCalibrationValue() {
        String digits = calibrationInput.replaceAll("[^0-9]","");
        int numDigits = digits.length();
        if (numDigits == 0) {
            return 0;
        } else if (numDigits == 1) {
            return (digits.charAt(0) - '0') * 11;
        } else {
            return (digits.charAt(0) - '0') * 10 + (digits.charAt(numDigits - 1) - '0');
        }
    }

    public static int getCalibrationSumFromLines(List<String> lines) {
        if (lines == null) {
            return 0;
        }
        return lines.stream().map(Calibration::new).map(Calibration::getCalibrationValue).reduce(Integer::sum).orElse(0);
    }

    public static int getCalibrationSumFromLinesWithWordDigits(List<String> lines) {
        if (lines == null) {
            return 0;
        }
        return lines.stream().map(Calibration::new)
                .map(Calibration::getCalibrationValueWithWordDigits)
                .reduce(Integer::sum).orElse(0);
    }

    private boolean withinRange(int index) {
        return index >= 0 && index < calibrationInput.length();
    }

    public int getCalibrationValueWithWordDigits() {
        List<Integer> firstIndices = Arrays.stream(digits).map(calibrationInput::indexOf)
                .map(index -> index < 0 ? calibrationInput.length() : index)
                .collect(Collectors.toList());
        int indexWithLeastFirstIndex = IntStream.range(0, firstIndices.size())
                .filter(listIndex -> withinRange(firstIndices.get(listIndex)))
                .reduce((left,right) -> firstIndices.get(left) > firstIndices.get(right) ? right : left)
                .orElse(-1);
        List<Integer> lastIndices = Arrays.stream(digits)
                .map(calibrationInput::lastIndexOf).collect(Collectors.toList());
        int indexWithGreatestLastIndex = IntStream.range(0, lastIndices.size())
                .filter(listIndex -> withinRange(lastIndices.get(listIndex)))
                .reduce((left,right) -> lastIndices.get(left) > lastIndices.get(right) ? left : right)
                .orElse(-1);
        String newString = (indexWithGreatestLastIndex < 0 || indexWithLeastFirstIndex < 0) ?
                "" :
                digits[indexWithLeastFirstIndex % 10].concat(digits[indexWithGreatestLastIndex % 10]);
        Calibration newCalibration = new Calibration(newString);
        return newCalibration.getCalibrationValue();
    }
}
