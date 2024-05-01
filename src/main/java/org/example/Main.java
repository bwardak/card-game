package org.example;

import org.example.deckOfCards.DeckOfCards;
import org.example.deckOfCards.DeckOfCardsUtils;


public class Main {
    public static void main(String[] args) {
        DeckOfCardsUtils deckk = new DeckOfCardsUtils();
        DeckOfCards deckcards = new DeckOfCards();
        deckcards.sortDeck();
        System.out.println(deckcards.dealCard());
        System.out.println(deckk.getCards());
    }
}