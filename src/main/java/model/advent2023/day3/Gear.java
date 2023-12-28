package model.advent2023.day3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Gear {
    private int rowNum;
    private int colNum;
    private final List<NumberGroup> numberGroups = new ArrayList<>();

    public boolean isAdjacentTo(NumberGroup numberGroup) {
        boolean rowAdjacent = Math.abs(this.rowNum - numberGroup.getRowNum()) <= 1;
        boolean columnAdjacent = colNum >= numberGroup.getColStart() - 1
                && colNum <= numberGroup.getColEnd() + 1;
        return rowAdjacent && columnAdjacent;
    }

    public void addAdjacentNumberGroup(NumberGroup numberGroup) {
        numberGroups.add(numberGroup);
    }

    public Integer getPower() {
        if (numberGroups.size() == 2) {
            return numberGroups.get(0).getValue() * numberGroups.get(1).getValue();
        }
        else {
            return 0;
        }
    }
}
