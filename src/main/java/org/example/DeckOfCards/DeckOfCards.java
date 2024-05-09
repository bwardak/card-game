package org.example.DeckOfCards;

import java.util.Random;

import static org.example.DeckOfCards.DeckOfCardsUtils.getCards;

public class DeckOfCards extends AbstractDeckOfCards{
    private static final Random RANDOM = new Random();
    private String randomCard;

    public String dealCard() {
        if (!getCards().isEmpty()){
            return getCards().remove(0);
        }
        throw new IllegalStateException("No cards left!");
    }

    public void sortDeck() {
        getCards().sort(new SortByCardNumber());
    }
}
