package model.advent2023.day1;

import model.advent2023.day1.Calibration;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class CalibrationTest {

    @Test
    public void testGetCalibrationWithNoDigits() {
        Calibration calibration = new Calibration("sakdfj");
        int value = calibration.getCalibrationValue();
        Assertions.assertEquals(0, value);
    }

    @Test
    public void testGetCalibrationWithOneDigit() {
        Calibration calibration = new Calibration("sak4dfj");
        int value = calibration.getCalibrationValue();
        Assertions.assertEquals(44, value);
    }


    @Test
    public void testGetCalibrationWithTwoDigits() {
        Calibration calibration = new Calibration("sa2kdf6j");
        int value = calibration.getCalibrationValue();
        Assertions.assertEquals(26, value);
    }

    @Test
    public void testGetCalibrationWithThreeDigits() {
        Calibration calibration = new Calibration("sa37kdf9j");
        int value = calibration.getCalibrationValue();
        Assertions.assertEquals(39, value);
    }

    @Test
    public void testGetCalibrationSumFromLines() {
        List<String> lines = List.of("1","2","3");
        int sum = Calibration.getCalibrationSumFromLines(lines);
        Assertions.assertEquals(66, sum);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsZeroDigits() {
        Calibration calibration = new Calibration("zer");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(0, value);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsOneDigit() {
        Calibration calibration = new Calibration("two");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(22, value);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsTwoDigitsMixed() {
        Calibration calibration = new Calibration("dsfsafdsa;afjkathreejfdskfjak8");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(38, value);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsTwoDigitsAreWords() {
        Calibration calibration = new Calibration("dsfsfourafdsa;4334afjkathreejfdskfjfdsfninedfjsk");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(49, value);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsTwoDigitsAreWordsAndOverlapping() {
        Calibration calibration = new Calibration("asdfeightwothreedsafjkdalsfj");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(83, value);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsTwoDigitsAreWordsAndOverlappingWithDigit() {
        Calibration calibration = new Calibration("asdfeightwothreeight9dsafjkdalsfj");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(89, value);
    }

    @Test
    public void testGetCalibrationValueWithWordDigitsTwoDigitsAreWordsAndOverlappingAtLast() {
        Calibration calibration = new Calibration("asdfeightwothreeightdsafjkdalsfj");
        int value = calibration.getCalibrationValueWithWordDigits();
        Assertions.assertEquals(88, value);
    }

    @Test
    public void testGetCalibrationSumFromLinesWithWordDigits() {
        List<String> lines = List.of("one","two","four");
        int sum = Calibration.getCalibrationSumFromLinesWithWordDigits(lines);
        Assertions.assertEquals(77, sum);
    }
}