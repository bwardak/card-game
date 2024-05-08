package org.example.Game;

import org.example.DeckOfCards.DeckOfCards;
import org.example.DeckOfCards.DeckOfCardsUtils;
import org.example.Utility.InputScanner;

import java.net.Socket;

public class HiLo extends Game {
    private DeckOfCards deck;
    private InputScanner userInput;

    public HiLo(String title, String rules) {
        super(title, rules);
        deck = new DeckOfCards();
        userInput = new InputScanner();
    }

        @Override
        public void play() {
            System.out.println("Welcome to Higher or Lower");
            printRules();
            System.out.println("Have Fun!!");
            System.out.println();

            System.out.println("Shuffling Deck...");
            deck.shuffleDeck();
            deck.shuffleDeck();
            boolean gameContinue;
            do {
                String currentCardString = deck.dealCard();
                int currentCardValue;
                switch (currentCardString.substring(0, currentCardString.length() - 1)) {
                    case "A":
                        currentCardValue = 1;
                        break;
                    case "J":
                        currentCardValue = 11;
                        break;
                    case "Q":
                        currentCardValue = 12;
                        break;
                    case "K":
                        currentCardValue = 13;
                        break;
                    default:
                        currentCardValue = Integer.parseInt(currentCardString.substring(0, currentCardString.length() - 1));
                        break;
                }

                System.out.println("The card is : " + currentCardString + ". Higher, lower or same?");

                String userGuess = userInput.useScanner().nextLine().toUpperCase();
                String nextCardString = deck.dealCard();
                int nextCardValue;
                switch (nextCardString.substring(0, nextCardString.length() - 1)) {
                    case "A":
                        nextCardValue = 1;
                        break;
                    case "J":
                        nextCardValue = 11;
                        break;
                    case "Q":
                        nextCardValue = 12;
                        break;
                    case "K":
                        nextCardValue = 13;
                        break;
                    default:
                        nextCardValue = Integer.parseInt(nextCardString.substring(0, nextCardString.length() - 1));
                        break;
                }

                gameContinue = false;
                if (userGuess.contains("H")) {
                    if (nextCardValue == currentCardValue) {
                        System.out.println("You lose, they were the same. Too bad");
                    } else if (nextCardValue > currentCardValue) {
                        System.out.println("Well done!");
                        gameContinue = true;
                    } else if (nextCardValue < currentCardValue) {
                        System.out.println("You lose, the next card was " + nextCardString + ". Try harder.");
                    }
                }
                if (userGuess.contains("L")) {
                    if (nextCardValue == currentCardValue) {
                        System.out.println("You lose, they were the same. Too bad");
                    } else if (nextCardValue < currentCardValue) {
                        System.out.println("Well done!");
                        gameContinue = true;
                    } else if (nextCardValue > currentCardValue) {
                        System.out.println("You Lose, the next card was " + nextCardString + ". Try again");
                    }
                }
                if (userGuess.contains("S")) {
                    if (nextCardValue == currentCardValue) {
                        System.out.println("Well done! They are the same value.");
                        gameContinue = true;
                    } else if (nextCardValue > currentCardValue) {
                        System.out.println("You lose, the next card was " + nextCardString);
                    } else if (nextCardValue < currentCardValue) {
                        System.out.println("You lose, the next card was " + nextCardString);
                    }
                }
            } while (gameContinue);
            playAgain();
        }

    @Override
    public boolean playAgain() {
        System.out.println("Play again? y/n");
        String input = userInput.useScanner().nextLine().toUpperCase();
        if(input.equals("Y")){
            play();
        } else if (input.equals("N")){
            System.out.println("Thanks for playing");
        }
        return false;
    }


    public void printRules(){
            System.out.println("1. You have to guess if the next card pulled will be higher, lower or the same card value than the current card. \n"
                    + "2. Ace is the lowest card \n"
                    + "3. Type 'H' for higher, 'L' for lower and 'S' for same \n"
                    + "4. Game ends when you guess incorrectly");
        }

};


