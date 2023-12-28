package model.advent2023.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GearTest {
    @Test
    void testIsAdjacentReturnsTrue() {
        NumberGroup numberGroup = new NumberGroup(0, 4, 3, 5);
        Gear gear = new Gear(5, 6);
        Assertions.assertTrue(gear.isAdjacentTo(numberGroup));
    }

    @Test
    void testIsAdjacentReturnsFalse() {
        NumberGroup numberGroup = new NumberGroup(0, 4, 3, 5);
        Gear gear = new Gear(7, 6);
        Assertions.assertFalse(gear.isAdjacentTo(numberGroup));
    }

    @Test
    void testGetPowerValidValue() {
        NumberGroup n1 = new NumberGroup(10, 4, 3, 5);
        NumberGroup n2 = new NumberGroup(15, 4, 3, 5);
        Gear gear = new Gear(7, 6);
        gear.addAdjacentNumberGroup(n1);
        gear.addAdjacentNumberGroup(n2);
        Assertions.assertEquals(150, gear.getPower());
    }

    @Test
    void testGetPowerInvalidValue() {
        NumberGroup n1 = new NumberGroup(10, 4, 3, 5);
        Gear gear = new Gear(7, 6);
        gear.addAdjacentNumberGroup(n1);
        Assertions.assertEquals(0, gear.getPower());
    }
}