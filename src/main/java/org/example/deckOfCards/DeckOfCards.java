package org.example.deckOfCards;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class DeckOfCards implements Comparator {
    DeckOfCardsUtils deck = new DeckOfCardsUtils();
    private static final Random RANDOM = new Random();
    private String randomCard;
    // method for card game
    // dealcard etc/
    public String dealCard() {
        String dealtCard = deck.getCards().get(0);
        System.out.println(dealtCard);
        return dealtCard;
    }

    public void sortDeck() {
        Collections.sort(deck.getCards());
    }

    public void shuffleDeck() {
        int randomIndex = RANDOM.nextInt((deck.getCards().size()));
        randomCard = deck.getCards().get(randomIndex);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
