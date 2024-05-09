package org.example.Game;

import org.example.DeckOfCards.DeckOfCards;
import org.example.Utility.InputScanner;

public class HiLo extends Game {
    private DeckOfCards deck;
    private InputScanner userInput;
    private int gamesPlayed;

    public HiLo(String title, String rules) {
        super(title, rules);
        deck = new DeckOfCards();
        userInput = new InputScanner();
    }

        @Override
        public void play() {

            System.out.println("Welcome to Higher or Lower");
            System.out.println("Have Fun!!");
            System.out.println();

            System.out.println("Shuffling Deck...");
            deck.shuffleDeck();
            deck.shuffleDeck();
            gamesPlayed = 0;
            System.out.println("Win streak: " + gamesPlayed);
            boolean gameContinue;
            do {
                String currentCardString = deck.dealCard();
                int currentCardValue = getCardValue(currentCardString);

                System.out.println("The card is : " + currentCardString + ". Higher, lower or same?");

                String userGuess = userInput.useScanner().nextLine().toUpperCase();
                String nextCardString = deck.dealCard();
                int nextCardValue = getCardValue(nextCardString);

                gameContinue = false;
                if (userGuess.equalsIgnoreCase("H")) {
                    if (nextCardValue == currentCardValue) {
                        System.out.println("You lose, they were the same. Too bad");
                        System.out.println();
                    } else if (nextCardValue > currentCardValue) {
                        System.out.println("Well done! The card was: " + nextCardString);
                        gameContinue = true;
                        gamesPlayed++;
                        System.out.println("Win Streak: " + gamesPlayed);
                        System.out.println();
                    } else if (nextCardValue < currentCardValue) {
                        System.out.println("You lose, the next card was " + nextCardString + ". Try harder.");
                        System.out.println();
                    }
                }
                if (userGuess.equalsIgnoreCase("L")) {
                    if (nextCardValue == currentCardValue) {
                        System.out.println("You lose, they were the same. Too bad");
                        System.out.println();
                    } else if (nextCardValue < currentCardValue) {
                        System.out.println("Well done! The card was: " + nextCardString);
                        gameContinue = true;
                        gamesPlayed++;
                        System.out.println("Win Streak: " + gamesPlayed);
                        System.out.println();
                    } else if (nextCardValue > currentCardValue) {
                        System.out.println("You Lose, the next card was " + nextCardString + ". Try again");
                        System.out.println();
                    }
                }
                if (userGuess.equalsIgnoreCase("S")) {
                    if (nextCardValue == currentCardValue) {
                        System.out.println("Well done! They are the same value.");
                        gameContinue = true;
                        gamesPlayed++;
                        System.out.println("Win Streak: " + gamesPlayed);
                        System.out.println();
                    } else if (nextCardValue > currentCardValue) {
                        System.out.println("You lose, the next card was " + nextCardString);
                        System.out.println();
                    } else if (nextCardValue < currentCardValue) {
                        System.out.println("You lose, the next card was " + nextCardString);
                        System.out.println();
                    }
                }
                if(!userGuess.equalsIgnoreCase("H") && !userGuess.equalsIgnoreCase("S") && !userGuess.equalsIgnoreCase("L")){
                    System.out.println("Invalid Input");
                    gameContinue = true;
                }
            } while (gameContinue);
            playAgain();
        }

    @Override
    public boolean playAgain() {
        System.out.println("Play again? (y/n)");
        String input = userInput.useScanner().nextLine().toUpperCase();
        if(input.equals("Y")){
            deck.resetDeck();
            play();
        } else if (input.equals("N")){
            System.out.println("Thanks for playing");
        }
        return true;
    }

    private int getCardValue(String CardString){
        switch (CardString.substring(0, CardString.length() - 1)) {
            case "A":
                return  1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(CardString.substring(0, CardString.length() - 1));

        }
    }

};


