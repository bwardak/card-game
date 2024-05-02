package org.example.Utility;

public class ScoreKeeping {

    private int gamesLost;
    private int gamesWon;

    public ScoreKeeping(int gamesLost, int gamesWon){
        this.gamesLost = gamesLost;
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }
}
