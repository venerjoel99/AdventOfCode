package model.advent2023.day5;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class BigMapTest {
    @Test
    void testBigMapGetValidValue() {
        Long input = 200L;
        MapEntry firstEntry = Mockito.mock(MapEntry.class);
        MapEntry secondEntry = Mockito.mock(MapEntry.class);
        MapEntry thirdEntry = Mockito.mock(MapEntry.class);
        Mockito.when(firstEntry.getValue(input)).thenReturn(null);
        Mockito.when(secondEntry.getValue(input)).thenReturn(400L);
        Mockito.when(thirdEntry.getValue(input)).thenReturn(null);
        BigMap bigMap = new BigMap("testSource", "testDestination");
        bigMap.addMapEntry(firstEntry);
        bigMap.addMapEntry(secondEntry);
        bigMap.addMapEntry(thirdEntry);
        Assertions.assertEquals(400L, bigMap.getValueOfInput(input));
    }

    @Test
    void testBigMapGetInvalidValue() {
        Long input = 200L;
        MapEntry firstEntry = Mockito.mock(MapEntry.class);
        MapEntry secondEntry = Mockito.mock(MapEntry.class);
        MapEntry thirdEntry = Mockito.mock(MapEntry.class);
        Mockito.when(firstEntry.getValue(input)).thenReturn(null);
        Mockito.when(secondEntry.getValue(input)).thenReturn(null);
        Mockito.when(thirdEntry.getValue(input)).thenReturn(null);
        BigMap bigMap = new BigMap("testSource", "testDestination");
        bigMap.addMapEntry(firstEntry);
        bigMap.addMapEntry(secondEntry);
        bigMap.addMapEntry(thirdEntry);
        Assertions.assertEquals(200L, bigMap.getValueOfInput(input));
    }

    @Test
    void testBigMapSourceAndDestination() {
        BigMap bigMap = new BigMap("testSource", "testDestination");
        Assertions.assertEquals("testSource", bigMap.getSourceName());
        Assertions.assertEquals("testDestination", bigMap.getDestinationName());
    }
}