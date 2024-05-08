package org.example.DeckOfCards;

import java.util.Comparator;

public class SortByCardNumber implements Comparator<String> {
    @Override
    public int compare(String card1, String card2) {
        CardValues c1 = getCardValue(card1);
        CardValues c2 = getCardValue(card2);
        return c1.ordinal() - c2.ordinal();
    }

    public CardValues getCardValue(String valueOfCard) {
        String cardRank = valueOfCard.substring(0, valueOfCard.length() - 1);
        return CardValues.fromValue(cardRank);
    }
}
