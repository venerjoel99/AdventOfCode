package model.advent2023.day3;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@AllArgsConstructor
public class NumberSolver {
    private List<NumberGroup> numberGroups;
    private Board board;
    private final Map<Integer, Gear> gearsMap = new HashMap<>();
    private boolean isPartNumber(NumberGroup numberGroup) {
        final int rowNum = numberGroup.getRowNum();
        for (int i = rowNum - 1; i <= rowNum + 1; i++) {
            IntStream intStream = numberGroup.getColumnsToCheck(i);
            int finalI = i;
            boolean result = intStream
                    .mapToObj(j -> board.isSymbol(finalI, j)).reduce((a, b) -> a || b)
                    .orElse(false);
            if (result) {
                return true;
            }
        }
        return false;
    }
    private void findAdjacentGears(NumberGroup numberGroup) {
        final int rowNum = numberGroup.getRowNum();
        for (int i = rowNum - 1; i <= rowNum + 1; i++) {
            IntStream intStream = numberGroup.getColumnsToCheck(i);
            int finalI = i;
            intStream.forEach(j -> {
                Integer coordinate = finalI * board.getColumns() + j;
                if (board.isGear(finalI, j)) {
                    if (gearsMap.containsKey(coordinate)) {
                        gearsMap.get(coordinate)
                                .addAdjacentNumberGroup(numberGroup);
                    } else {
                        Gear gear = new Gear(finalI, j);
                        gearsMap.put(coordinate, gear);
                        gear.addAdjacentNumberGroup(numberGroup);
                    }
                }
            });
        }
    }
    private int getNumberGroupValue(NumberGroup numberGroup) {
        return isPartNumber(numberGroup) ? numberGroup.getValue() : 0;
    }
    public int getTotalValue() {
        return numberGroups.stream()
                .map(this::getNumberGroupValue)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getTotalPower() {
        numberGroups.forEach(this::findAdjacentGears);
        return gearsMap.values().stream()
                .map(Gear::getPower)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
