package model.advent2023.day4;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Card {
    private final List<Integer> winningNumbers;
    private final List<Integer> scratchPadNumbers;
    private List<Integer> getMatchingNumbers() {
        List<Integer> result = new java.util.ArrayList<>(List.copyOf(scratchPadNumbers));
        result.retainAll(winningNumbers);
        return result;
    }
    public int getCardScore() {
        int matches = getMatchingNumbers().size();
        return matches > 0 ? 1 << (matches - 1) : 0;
    }
}