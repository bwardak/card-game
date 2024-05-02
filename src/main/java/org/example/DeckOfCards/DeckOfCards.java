package org.example.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public ArrayList<String> shuffleDeck() {
        Collections.shuffle(cards);
        return getCards();
    }

//    @Override
//    public int compare(String card1, String card2) {
//        if (card1.startsWith("10") && !card2.startsWith("10")){
//            return 1;
//        } else if (!card1.startsWith("10") && card2.startsWith("10")) {
//            return -1;
//        }
//
//        CardValues c1 = getCardValue(card1);
//        CardValues c2 = getCardValue(card2);
//        return c1.ordinal() - c2.ordinal();
//    }
//
//    private CardValues getCardValue(String valueOfCard) {
//        if (valueOfCard.startsWith("10")) {
//            valueOfCard = "10";
//        }
//        return CardValues.fromValue(valueOfCard);
//    }

    public ArrayList<String> resetDeck(){
        cards = deck.getStoredCards();
        return cards;
    }

    public void printDeck(){
        System.out.println(getCards());
    }
}
