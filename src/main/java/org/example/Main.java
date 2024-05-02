package org.example;

import org.example.DeckOfCards.DeckOfCards;
import org.example.DeckOfCards.DeckOfCardsUtils;
import org.example.Game.Blackjack;
import org.example.Utility.UserCreation;


public class Main {
    public static void main(String[] args) {
        DeckOfCardsUtils deckk = new DeckOfCardsUtils();
        DeckOfCards deckcards = new DeckOfCards();
        Blackjack blackjack = new Blackjack();
        UserCreation user = new UserCreation();

//        user.nameCreation();



        deckcards.printDeck();
//        blackjack.printRules();
        blackjack.dealPlayersHand();
        blackjack.dealPlayersHand();
        blackjack.showPlayersHand();
        blackjack.dealDealersHand();
        blackjack.dealDealersHand();
        blackjack.showRoundStats();
        blackjack.showDealerHand();
        deckcards.printDeck();
        blackjack.chooseHitOrStand();
    }
}