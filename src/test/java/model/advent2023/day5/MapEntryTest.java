package model.advent2023.day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapEntryTest {

    @Test
    void testGetValue() {
        MapEntry mapEntry = new MapEntry(100L, 200L, 50L);
        Assertions.assertEquals(149L, mapEntry.getValue(249L));
        Assertions.assertEquals(100L, mapEntry.getValue(200L));
        Assertions.assertEquals(120L, mapEntry.getValue(220L));
        Assertions.assertEquals(null, mapEntry.getValue(250L));
        Assertions.assertEquals(null, mapEntry.getValue(130L));
    }
}