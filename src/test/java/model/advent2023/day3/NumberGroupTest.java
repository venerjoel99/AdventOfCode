package model.advent2023.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class NumberGroupTest {

    @Test
    void testNumberGroupTest() {
        NumberGroup numberGroup = new NumberGroup(1,2,3,4);
        Assertions.assertEquals(1, numberGroup.getValue());
        Assertions.assertEquals(2, numberGroup.getRowNum());
        Assertions.assertEquals(3, numberGroup.getColStart());
        Assertions.assertEquals(4, numberGroup.getColEnd());
        numberGroup.setValue(5);
        numberGroup.setRowNum(6);
        numberGroup.setColStart(7);
        numberGroup.setColEnd(8);
        Assertions.assertEquals(5, numberGroup.getValue());
        Assertions.assertEquals(6, numberGroup.getRowNum());
        Assertions.assertEquals(7, numberGroup.getColStart());
        Assertions.assertEquals(8, numberGroup.getColEnd());
    }

    @Test
    void testNumberGroupGetColumnsToCheckFor() {
        NumberGroup numberGroup = new NumberGroup(1,2,3,6);
        IntStream intStream = numberGroup.getColumnsToCheck(1);
        List<Integer> integerList  = intStream.boxed().collect(Collectors.toList());
        Assertions.assertEquals(6, integerList.size());
        for (int i = 2; i <= 7; i++) {
            Assertions.assertTrue(integerList.contains(i));
        }
    }

    @Test
    void testNumberGroupGetColumnsToCheckForExactRow() {
        NumberGroup numberGroup = new NumberGroup(1,2,3,6);
        IntStream intStream = numberGroup.getColumnsToCheck(2);
        List<Integer> integerList  = intStream.boxed().collect(Collectors.toList());
        Assertions.assertEquals(2, integerList.size());
        Assertions.assertTrue(integerList.contains(2));
        Assertions.assertTrue(integerList.contains(7));
    }

    @Test
    void testNumberGroupGetColumnsToCheckForFarOutRow() {
        NumberGroup numberGroup = new NumberGroup(1,2,3,6);
        IntStream intStream = numberGroup.getColumnsToCheck(4);
        List<Integer> integerList  = intStream.boxed().collect(Collectors.toList());
        Assertions.assertTrue(integerList.isEmpty());
    }

}