package model.advent2023.day4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

class CardTest {
    @Test
    void testGetCardScore() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 4, 6, 5, 9);
        Card card = new Card(winningNumbers, scratchPadNumbers);
        Assertions.assertEquals(8, card.getCardScore());
    }
    @Test
    void testGetCardScoreDuplicateMatches() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 4, 6, 5, 5);
        Card card = new Card(winningNumbers, scratchPadNumbers);
        Assertions.assertEquals(8, card.getCardScore());
    }

    @Test
    void testGetCardScoreOneMatch() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 1, 1, 1, 1);
        Card card = new Card(winningNumbers, scratchPadNumbers);
        Assertions.assertEquals(1, card.getCardScore());
    }

    @Test
    void testGetCardScoreNoMatch() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(35, 3, 6, 2, 1);
        Card card = new Card(winningNumbers, scratchPadNumbers);
        Assertions.assertEquals(0, card.getCardScore());
    }
}