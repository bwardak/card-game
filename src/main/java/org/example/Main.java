package org.example;

import org.example.Game.ChooseGame;
import org.example.Game.Game;
import org.example.Game.HomeScreen;

public class Main {
    public static void main(String[] args) {
        Game game;
        HomeScreen homeScreen = new HomeScreen();
        do {
            do {
                homeScreen.printGames();
                game = homeScreen.chooseGame();
                game.printRules();
                game.play();
            } while (homeScreen.replayGame());
        } while (homeScreen.backToHomeScreen());

    }
}