package org.example.Game;

import org.example.Utility.InputScanner;

public class HomeScreen implements ChooseGame{
    private InputScanner userInput;

    HiLo hilo = new HiLo("HiLo", "1. You have to guess if the next card pulled will be higher, lower or the same card value than the current card. \n"
            + "2. Ace is the lowest card \n"
            + "3. Type 'H' for higher, 'L' for lower and 'S' for same \n"
            + "4. Game ends when you guess incorrectly");
    Blackjack blackjack = new Blackjack();


    @Override
    public void printGames() {
        System.out.println("Choose a game to play!");
        System.out.println("1) HiLo");
        System.out.println("2) Blackjack");
        System.out.println("3) Exit");
    }

    @Override
    public Game chooseGame() {
        String input = InputScanner.useScanner().nextLine();
        if (input.equalsIgnoreCase("1")){
            return hilo;
        } else if (input.equalsIgnoreCase("2")) {
            return blackjack;
        } else if (input.equalsIgnoreCase("3")) {
            System.out.println("Bye!");
            System.exit(0);
        }
        return null;
    }

    public boolean backToHomeScreen() {
        return true;
    }

    public boolean replayGame() {
        return true;
    }
}
