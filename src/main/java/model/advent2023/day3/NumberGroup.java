package model.advent2023.day3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class NumberGroup {
    private int value;
    private int rowNum;
    private int colStart;
    private int colEnd;
    public IntStream getColumnsToCheck(int rowToCheckFor) {
        if (Math.abs(rowToCheckFor - rowNum) <= 1) {
            return rowToCheckFor == rowNum ?
                    IntStream.of(colStart - 1, colEnd + 1) :
                    IntStream.range(colStart - 1, colEnd + 2);
        } else {
            return IntStream.range(0,0);
        }
    }
}
