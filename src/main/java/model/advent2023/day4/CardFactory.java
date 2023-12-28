package model.advent2023.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardFactory {
    private static final Map<Integer, Card> cardIdMap = new HashMap<>();
    public static Card getCardFromLine(String line) {
        String[] tokens = line.trim().split(":");
        String[] cardIdString = tokens[0].trim().split(" +");
        Integer cardId = Integer.parseInt(cardIdString[1]);
        String[] numberStrings = tokens[1].split("\\|");
        String[] winningNumStr = numberStrings[0].trim().split(" +");
        String[] scratchPadNumStr = numberStrings[1].trim().split(" +");
        List<Integer> winningNumbers =
                Arrays.stream(winningNumStr)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> scratchPadNumbers =
                Arrays.stream(scratchPadNumStr)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        Card card = new Card(winningNumbers, scratchPadNumbers, 1);
        cardIdMap.put(cardId, card);
        return card;
    }

    public static Card getCardById(Integer id) {
        return cardIdMap.getOrDefault(id, null);
    }


}
