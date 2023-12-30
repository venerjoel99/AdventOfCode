package model.advent2023.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SeedMapperTest {
    @Test
    void getLocationValueOfSeed() {
        BigMap bigMapSeedToTemp = Mockito.mock(BigMap.class);
        BigMap bigMapTempToLocation = Mockito.mock(BigMap.class);
        Mockito.when(bigMapSeedToTemp.getDestinationName()).thenReturn("temperature");
        Mockito.when(bigMapTempToLocation.getDestinationName()).thenReturn("location");
        Mockito.when(bigMapSeedToTemp.getValueOfInput(100L)).thenReturn(200L);
        Mockito.when(bigMapTempToLocation.getValueOfInput(200L)).thenReturn(400L);
        SeedMapper seedMapper = new SeedMapper();
        seedMapper.addSourceAndMapping("seed", bigMapSeedToTemp);
        seedMapper.addSourceAndMapping("temperature", bigMapTempToLocation);
        Assertions.assertEquals(400L, seedMapper.getLocationValueOfSeed(100L));
    }
}