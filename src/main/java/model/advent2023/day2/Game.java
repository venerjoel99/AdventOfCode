package model.advent2023.day2;
import lombok.Getter;

import java.util.List;

@Getter
public class Game {
    private final int gameId;
    private final List<CubeSet> cubeSetList;
    public Game(int gameId, List<CubeSet> cubeSetList) {
        this.cubeSetList = cubeSetList;
        this.gameId = gameId;
    }

    public boolean isGamePossible(CubeSet inventory) {
        return cubeSetList.stream()
                .map(round -> round.isSubSetOf(inventory))
                .reduce((a, b) -> a && b)
                .orElse(true);
    }

    public Integer getPower() {
        CubeSet powerCubeSet = new CubeSet();
        cubeSetList.forEach(powerCubeSet::replaceWithOtherCubeSetGreaterQuantities);
        return powerCubeSet.getPower();
    }
}
