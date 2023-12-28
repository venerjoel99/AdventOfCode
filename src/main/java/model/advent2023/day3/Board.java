package model.advent2023.day3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {
    private final List<String> boardStrings;
    @Getter
    private final int rows;
    @Getter
    private final int columns;
    private final List<Gear> gears = new ArrayList<>();
    public Board(List<String> boardStrings) {
        rows = boardStrings.size();
        columns = boardStrings.get(0).length();
        this.boardStrings = boardStrings;
    }
    private void parseLine(String line, int rowNum, List<NumberGroup> numberGroups) {
        boolean isNumber = false;
        int currentNum = 0;
        int start = -1;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= '0' && c <= '9') {
                currentNum *= 10;
                currentNum += (c - '0');
                if (!isNumber) {
                    start = i;
                    isNumber = true;
                }
            } else if (isNumber){
                numberGroups.add(new NumberGroup(currentNum, rowNum, start, i - 1));
                isNumber = false;
                currentNum = 0;
            }
            if (c == '*') {
                gears.add(new Gear(rowNum, i));
            }
        }
        if (isNumber) {
            numberGroups.add(new NumberGroup(currentNum, rowNum, start, line.length() - 1));
        }
    }

    public List<NumberGroup> getNumberGroups() {
        final List<NumberGroup> numberGroups = new ArrayList<>();
        IntStream.range(0, boardStrings.size())
                .forEach(index -> parseLine(boardStrings.get(index), index, numberGroups));
        return numberGroups;
    }

    public boolean isSymbol(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }
        char c = boardStrings.get(x).charAt(y);
        return c != '.' && !(c >= '0' && c <= '9');
    }

    public boolean isGear(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }
        return boardStrings.get(x).charAt(y) == '*';
    }

}
