package org.example;

import org.example.DeckOfCards.DeckOfCards;
import org.example.DeckOfCards.DeckOfCardsUtils;


public class Main {
    public static void main(String[] args) {
        DeckOfCardsUtils deckk = new DeckOfCardsUtils();
        DeckOfCards deckcards = new DeckOfCards();


        deckcards.printDeck();
        deckcards.sortDeck();
        deckcards.printDeck();
    }
}