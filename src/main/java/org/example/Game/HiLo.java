package org.example.Game;

import org.example.DeckOfCards.DeckOfCards;
import org.example.DeckOfCards.DeckOfCardsUtils;
import org.example.Utility.InputScanner;

import javax.smartcardio.Card;
import java.sql.SQLOutput;


public class HiLo extends Game {
    private DeckOfCards deck;
    private InputScanner userInput;

    public HiLo(String title, String rules) {
        super(title, rules);
        deck = new DeckOfCards();
        userInput = new InputScanner();
    }

    private Game game = new Game("Higher or Lower", "1. You have to guess if the next card pulled will be higher, lower or the same card value than the current card."
            + "\n 2. Ace is the lowest card"
            + "\n 3. Type 'H' for higher, 'L' for lower and 'S' for same "
            + "\n Game ends when you guess incorrectly") {
        @Override
        public void play() {
            game.printTitle();
            game.printRules();
            do{
                System.out.println("Shuffling Deck...");
                deck.shuffleDeck();
                deck.shuffleDeck();
                System.out.println("The card is : " + deck.dealCard() + ". Higher, lower or same?");

                String userGuess = getUserInput().toString().toUpperCase();
                if (userGuess.contains("H")){
                    String nextCard = deck.dealCard();
                    if (nextCard.equals()){
                        System.out.println("You lose, they were the same. Too bad");
                    } else if (getDeck().get > deck.dealCard()){
                        System.out.println("Well done!");
                    } else{
                        System.out.println("You lose, the next card was lower. Try harder.");
                    }
                }

            }
        }

        @Override
        public boolean playAgain() {
            return false;
        }
    };



    public DeckOfCards getDeck() {
        return deck;
    }

    public void setDeck(DeckOfCards deck) {
        this.deck = deck;
    }

    public InputScanner getUserInput() {
        return userInput;
    }

    public void setUserInput(InputScanner userInput) {
        this.userInput = userInput;
    }

    @Override
    public void play() {

    }

    @Override
    public boolean playAgain() {
        return false;
    }

    // rules of the game
    // 1. ace is lowest card
    // 2. jack, queen, king
    // 3. if cards at the same number
        //  either
            // game ends
            // dependant on suit strength
                // diamond, club, heart, spade // so much harder.
            // have a third option of high, low or same.


//    public void playHiLo() {
//        // pull first card
//        //user input of if they think its higher or lower (higher || lower )
//
//        System.out.println();
//    }
public static void main(String[] args){
        DeckOfCards deck1 = new DeckOfCards();
        InputScanner scanner = new InputScanner();

    System.out.println("Shuffling Deck...");
    deck1.shuffleDeck();
    deck1.shuffleDeck();
    System.out.println("The card is : " + deck1.dealCard() + ". Higher, lower or same?");





}

}
