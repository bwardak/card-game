package org.example.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;

import static org.example.DeckOfCards.DeckOfCardsUtils.cards;
import static org.example.DeckOfCards.DeckOfCardsUtils.getCards;

public abstract class AbstractDeckOfCards implements Deck{
    @Override
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    @Override
    public abstract String dealCard();

    @Override
    public void resetDeck() {
        ArrayList<String> originalStoredCards = new ArrayList<>(DeckOfCardsUtils.getStoredCards());
        cards = originalStoredCards;
    }

    @Override
    public void printDeck() {
        System.out.println(getCards());
    }
}
