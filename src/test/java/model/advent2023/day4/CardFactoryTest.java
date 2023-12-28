package model.advent2023.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardFactoryTest {

    @Test
    void getCardFromLine() {
        String line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = CardFactory.getCardFromLine(line);
        Assertions.assertEquals(8, card.getCardScore());
        Assertions.assertEquals(1, card.getCopies());
    }

    @Test
    void getCardById() {
        String line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = CardFactory.getCardFromLine(line);
        Assertions.assertSame(card, CardFactory.getCardById(1));
    }
}