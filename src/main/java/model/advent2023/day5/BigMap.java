package model.advent2023.day5;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class BigMap {
    @Getter
    private String sourceName;
    @Getter
    private String destinationName;
    private final List<MapEntry> mapEntries = new ArrayList<>();
    public void addMapEntry(MapEntry mapEntry) {
        mapEntries.add(mapEntry);
    }
    public Long getValueOfInput(Long sourceInput) {
        return mapEntries.stream()
                .map(mapEntry -> mapEntry.getValue(sourceInput))
                .filter(Objects::nonNull)
                .findAny()
                .orElse(sourceInput);
    }
}