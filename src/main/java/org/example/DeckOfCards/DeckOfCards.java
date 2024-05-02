package org.example.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import static org.example.DeckOfCards.DeckOfCardsUtils.cards;
import static org.example.DeckOfCards.DeckOfCardsUtils.getCards;

public class DeckOfCards implements Comparator {
    DeckOfCardsUtils deck = new DeckOfCardsUtils();
    private static final Random RANDOM = new Random();
    private String randomCard;


    public String dealCard() {
        String dealtCard = deck.getCards().get(0);
        System.out.println(dealtCard);
        return dealtCard;
    }

    public void sortDeck() {
        Collections.sort(deck.getCards());
    }

    public ArrayList<String> shuffleDeck() {
        Collections.shuffle(cards);
        return getCards();
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public ArrayList<String> resetDeck(){
        cards = deck.getStoredCards();
        return cards;
    }

    public void printDeck(){
        System.out.println(getCards());
    }
}
