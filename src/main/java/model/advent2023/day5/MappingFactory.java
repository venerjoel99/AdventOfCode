package model.advent2023.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingFactory {
    public static List<Long> generateListOfSeedsFromLine(String line) {
        String[] tokens = line.split(":");
        String[] seedNumStrings = tokens[1].trim().split(" +");
        return Arrays.stream(seedNumStrings)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private static BigMap createBigMapFromLine(String line) {
        String[] tokens = line.split(" ");
        String[] mapNameTokens = tokens[0].split("-");
        String source = mapNameTokens[0];
        String destination = mapNameTokens[2];
        return new BigMap(source, destination);
    }

    private static MapEntry createMapEntryFromLine(String line) {
        String[] numberStrings = line.trim().split(" +");
        Long destination = Long.parseLong(numberStrings[0]);
        Long source = Long.parseLong(numberStrings[1]);
        Long range = Long.parseLong(numberStrings[2]);
        return new MapEntry(destination, source, range);
    }

    public static SeedMapper generateSeedMappingsFromLines(List<String> lines) {
        SeedMapper seedMapper = new SeedMapper();
        BigMap bigMap = null;
        for (String line : lines) {
            if (!line.isEmpty()) {
                if (line.contains("map")) {
                    bigMap = createBigMapFromLine(line);
                }
                else if (bigMap != null){
                    bigMap.addMapEntry(createMapEntryFromLine(line));
                }
            } else if (bigMap != null) {
                seedMapper.addSourceAndMapping(bigMap.getSourceName(), bigMap);
            }
        }
        if (bigMap != null) {
            seedMapper.addSourceAndMapping(bigMap.getSourceName(), bigMap);
        }
        return seedMapper;
    }
}
