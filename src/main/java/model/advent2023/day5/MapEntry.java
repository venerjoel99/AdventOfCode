package model.advent2023.day5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MapEntry {
    private Long destinationStart;
    private Long sourceStart;
    private Long range;
    public Long getValue(Long sourceInput) {
        long diff = sourceInput - sourceStart;
        return (diff >= 0 && diff < range) ?
                destinationStart + diff : null;
    }
}
