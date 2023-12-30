package model.advent2023.day5;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class SeedMapper {
    private final Map<String, BigMap> sourceToEntry = new HashMap<>();
    public void addSourceAndMapping(String source, BigMap bigMap) {
        sourceToEntry.put(source, bigMap);
    }
    public Long getLocationValueOfSeed(Long seedNumber) {
        String currentSource = "seed";
        Long currentNumber = seedNumber;
        while (!currentSource.equals("location")) {
            BigMap bigMap = sourceToEntry.get(currentSource);
            currentNumber = bigMap.getValueOfInput(currentNumber);
            currentSource = bigMap.getDestinationName();
        }
        return currentNumber;
    }
}
