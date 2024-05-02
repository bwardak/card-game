package org.example;

import org.example.DeckOfCards.DeckOfCards;
import org.example.DeckOfCards.DeckOfCardsUtils;
import org.example.Utility.UserCreation;


public class Main {
    public static void main(String[] args) {
        DeckOfCardsUtils deckk = new DeckOfCardsUtils();
        DeckOfCards deckcards = new DeckOfCards();
        UserCreation user = new UserCreation();

        user.nameCreation();


        deckcards.printDeck();
        deckcards.sortDeck();
        deckcards.printDeck();
        deckcards.resetDeck();
        deckcards.printDeck();
    }
}