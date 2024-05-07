package org.example.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.example.DeckOfCards.DeckOfCardsUtils.cards;
import static org.example.DeckOfCards.DeckOfCardsUtils.getCards;

public class DeckOfCards {
    DeckOfCardsUtils deck = new DeckOfCardsUtils();
    private static final Random RANDOM = new Random();
    private String randomCard;

    public String dealCard() {
        String dealtCard = deck.getCards().remove(0);
        return dealtCard;
    }

    public void sortDeck() {
        Collections.sort(deck.getCards(), new SortByCardNumber());
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void resetDeck(){
        ArrayList<String> originalStoredCards = new ArrayList<>(DeckOfCardsUtils.getStoredCards());
        System.out.println(cards + "test " + cards.size());
        cards = originalStoredCards;
        System.out.println(cards + "test " + cards.size());
    }

    public void printDeck(){
        System.out.println(getCards());
    }
}
