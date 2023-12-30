package model.advent2023.day5;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SeedSolver {
    private List<Long> seeds;
    private SeedMapper seedMapper;
    public Long getMinLocationValue() {
        return seeds.stream()
                .map(seedMapper::getLocationValueOfSeed)
                .min(Long::compare)
                .orElse(0L);
    }
}
