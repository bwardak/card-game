package org.example.deckOfCards;

import java.util.ArrayList;

public class DeckOfCardsUtils {
    // storing cards
    // static
    public static ArrayList<String> cards = new ArrayList<>();

    static {
        String[] suits = {"♣", "♦", "♠", "♥"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] ranksValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(rank + suit);
            }
        }
    }

    public static ArrayList<String> getCards() {
        return cards;
    }
}
