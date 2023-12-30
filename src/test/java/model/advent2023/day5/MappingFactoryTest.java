package model.advent2023.day5;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.AdventUtils;

import java.io.IOException;
import java.util.List;

class MappingFactoryTest {

    @Test
    void generateListOfSeedsFromLine() {
        String line = "seeds: 12 13 14";
        List<Long> seeds = MappingFactory.generateListOfSeedsFromLine(line);
        Assertions.assertEquals(3, seeds.size());
        Assertions.assertTrue(seeds.contains(12L));
        Assertions.assertTrue(seeds.contains(13L));
        Assertions.assertTrue(seeds.contains(14L));
    }

    @Test
    void generateSeedMappingsFromLines() throws IOException {
        List<String> lines = AdventUtils.readLinesFromResourceFiles("Advent2023Day5TestFile.txt");
        SeedMapper seedMapper = MappingFactory.generateSeedMappingsFromLines(lines);
        Assertions.assertTrue(seedMapper.getLocationValueOfSeed(1L) > 0L);
    }
}