package model.advent2023.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CubeSet {
    private final Map<String, Integer> cubeInventory = new HashMap<>();

    public void insertCubes(String color, Integer quantity) {
        if (quantity > 0) {
            int newQuantity = cubeInventory.getOrDefault(color, 0) + quantity;
            cubeInventory.put(color, newQuantity);
        }
    }

    public Integer getNumberOfCubes(String color) {
        return cubeInventory.getOrDefault(color, 0);
    }

    public boolean isSubSetOf(CubeSet other) {
        Set<String> colors = this.cubeInventory.keySet();
        return colors.stream()
                .map(color -> (this.getNumberOfCubes(color) <= other.getNumberOfCubes(color)))
                .reduce((a, b) -> a && b)
                .orElse(true);
    }

    public Integer getPower() {
        return cubeInventory.values().stream().reduce((a,b) -> a * b).orElse(0);
    }

    private void replaceWithNewQuantityIfGreater(String color, Integer quantity) {
        Integer oldQuantity = cubeInventory.getOrDefault(color, 0);
        cubeInventory.put(color, Integer.max(oldQuantity, quantity));
    }

    public void replaceWithOtherCubeSetGreaterQuantities(CubeSet other) {
        other.cubeInventory.keySet().forEach(color ->
                this.replaceWithNewQuantityIfGreater(color, other.getNumberOfCubes(color)));
    }
}
