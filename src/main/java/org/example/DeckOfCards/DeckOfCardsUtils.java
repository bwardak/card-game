package org.example.DeckOfCards;

import java.util.ArrayList;

public class DeckOfCardsUtils {

    public static ArrayList<String> cards = new ArrayList<>();
    public static ArrayList<String> storedCards = new ArrayList<>();

    static {
        String[] suits = {"♣", "♦", "♠", "♥"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(rank + suit);
                storedCards.add(rank + suit);
            }
        }
    }

    public static ArrayList<String> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<String> cards) {
        DeckOfCardsUtils.cards = cards;
    }

    public static ArrayList<String> getStoredCards() {
        return storedCards;
    }
}
