package model.advent2023.day4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

class CardTest {
    @Test
    void testGetCardScore() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 4, 6, 5, 9);
        Card card = new Card(winningNumbers, scratchPadNumbers,1);
        Assertions.assertEquals(8, card.getCardScore());
    }
    @Test
    void testGetCardScoreDuplicateMatches() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 4, 6, 5, 5);
        Card card = new Card(winningNumbers, scratchPadNumbers, 1);
        Assertions.assertEquals(8, card.getCardScore());
    }

    @Test
    void testGetCardScoreOneMatch() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 1, 1, 1, 1);
        Card card = new Card(winningNumbers, scratchPadNumbers, 1);
        Assertions.assertEquals(1, card.getCardScore());
    }

    @Test
    void testGetCardScoreNoMatch() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(35, 3, 6, 2, 1);
        Card card = new Card(winningNumbers, scratchPadNumbers,1);
        Assertions.assertEquals(0, card.getCardScore());
    }

    @Test
    void testGetNumberOfMatches() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 4, 6, 5, 5);
        Card card = new Card(winningNumbers, scratchPadNumbers, 1);
        Assertions.assertEquals(4, card.getNumberOfMatches());
    }

    @Test
    void testIncreaseCopies() {
        List<Integer> winningNumbers = List.of(4, 5, 9, 89, 34, 5);
        List<Integer> scratchPadNumbers = List.of(34, 4, 6, 5, 5);
        Card card = new Card(winningNumbers, scratchPadNumbers, 3);
        card.increaseCopies(10);
        Assertions.assertEquals(13, card.getCopies());
    }
}