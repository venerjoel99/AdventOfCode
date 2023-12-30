package model.advent2023.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeedSolverTest {

    @Test
    void getMinLocationValue() {
        SeedMapper seedMapper = Mockito.mock(SeedMapper.class);
        Mockito.when(seedMapper.getLocationValueOfSeed(100L)).thenReturn(20L);
        Mockito.when(seedMapper.getLocationValueOfSeed(200L)).thenReturn(10L);
        List<Long> seeds = List.of(100L, 200L);
        SeedSolver seedSolver = new SeedSolver(seeds, seedMapper);
        Assertions.assertEquals(10L, seedSolver.getMinLocationValue());
    }
}