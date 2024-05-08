package org.example.Game;

import org.example.DeckOfCards.CardValuesInt;
import org.example.DeckOfCards.DeckOfCards;
import org.example.DeckOfCards.SortByCardNumber;
import org.example.Utility.InputScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Blackjack extends Game{
    private ArrayList<String> playersHand = new ArrayList<>();
    private ArrayList<String> dealersHand = new ArrayList<>();
    private int playerScore;
    private int dealerScore;
    private int playerIndex = 0;
    private int dealerIndex = 0;
    private int playerMoney = 1000;
    private int currentBet = 0;
    private boolean showRules = true;

    DeckOfCards cardCommands = new DeckOfCards();
    SortByCardNumber cardValue = new SortByCardNumber();

    public Blackjack() {
        super("Blackjack", blackjackRules());
    }

    public static String blackjackRules() {
        return "\nRules of Blackjack \n\n" +
                "Objective:\n    Get cards totaling closer to 21 than the dealer, without going over 21.\n" +
                "Card Values:\n    Cards 2-10 are worth their face value.\n" +
                "    Face cards (Jack, Queen, King) are each worth 10 points.\n" +
                "    Aces can count as 1 or 11 points.\n" +
                "Dealing:\n    You get two cards as does the dealer, with one of the dealers cards exposed.\n" +
                "    Hit: Take an additional card to get closer to 21.\n" +
                "    Stand: Stay with your current total.\n" +
                "Busting: \n" +
                "    If your hand goes above 21, its a bust and you lose.\n" +
                "Blackjack: \n" +
                "    If your hand hits 21 you win.\n" +
                "Dealer: \n" +
                "    The dealer will go after your turn.\n" +
                "    They will hit while below 17, or stand if on 17 and above.";
    }

    public void placeBet() {
        if (playerMoney > 0) {
            displayPlayerMoney();
            System.out.print("Enter a bet: ");
            Scanner scanner = InputScanner.useScanner();
            String input = scanner.nextLine();
            if (!input.matches(".*[0-9].*")) {
                System.out.println("You must enter a number!");
                placeBet();
            } else {
                currentBet = Integer.parseInt(input);
                System.out.println(currentBet);
                if (playerMoney >= currentBet) {
                    playerMoney = playerMoney - currentBet;
                } else {
                    System.out.println("You do not have this much money. Please bet again.");
                    placeBet();
                }
            }

        }
    }

    public void displayPlayerMoney() {
        System.out.println("\nYour money: $" + playerMoney);
    }

    public void dealPlayersHand() {
        cardCommands.shuffleDeck();
        playersHand.add(cardCommands.dealCard());
    }

    public void turnPlayerHandIntoCards() {
        String[] lines = new String[7];

        Arrays.fill(lines, "");

        for (String card : playersHand) {
            lines[0] += " ----------   ";
            lines[1] += "|          |  ";
            lines[2] += "|          |  ";
            if (card.startsWith("10")) {
                lines[3] += "|    " + card + "   |  ";
            } else {
                lines[3] += "|    " + card + "    |  ";
            }
            lines[4] += "|          |  ";
            lines[5] += "|          |  ";
            lines[6] += " ----------   ";
        }

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public void showPlayersHand() {
        System.out.println("\nYour hand: \n");
        turnPlayerHandIntoCards();
    }

    public void dealDealersHand() {
        dealersHand.add(cardCommands.dealCard());
    }

    public void turnDealerHandIntoCards() {
        String[] lines = new String[7];

        Arrays.fill(lines, "");

        for (int i = 0; i < dealersHand.size(); i++) {
            if (i == dealersHand.size() - 1 && dealerScore < 17) {
                lines[0] += " ----------   ";
                lines[1] += "|          |  ";
                lines[2] += "|          |  ";
                lines[3] += "|    ?     |  ";
                lines[4] += "|          |  ";
                lines[5] += "|          |  ";
                lines[6] += " ----------   ";
            } else if (i == dealersHand.size() - 1) {
                System.out.println(" ");
            } else {
                String card = dealersHand.get(i);
                lines[0] += " ----------   ";
                lines[1] += "|          |  ";
                lines[2] += "|          |  ";
                if (card.startsWith("10")) {
                    lines[3] += "|    " + card + "   |  ";
                } else {
                    lines[3] += "|    " + card + "    |  ";
                }
                lines[4] += "|          |  ";
                lines[5] += "|          |  ";
                lines[6] += " ----------   ";
            }
        }

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public void showDealerHand() {
        System.out.println("\nDealers hand: \n");
        turnDealerHandIntoCards();
    }

    public void showRoundStats() {
        for (int i = playerIndex; i < playersHand.size(); i++) {
            playerScore += CardValuesInt.matchValue(playersHand.get(i));
            playerIndex++;
        }
        for (int i = dealerIndex; i < dealersHand.size() - 1; i++) {
            dealerScore += CardValuesInt.matchValue(dealersHand.get(i));
            dealerIndex++;
        }
        if ((playersHand.contains("A♣") || playersHand.contains("A♦") || playersHand.contains("A♠") || playersHand.contains("A♥")) && playerScore < 11) {
            System.out.println("\nPlayer score: " + playerScore + " or " + (playerScore + 10));
        } else {
            System.out.println("\nPlayer score: " + playerScore);
        }
        if ((dealersHand.contains("A♣") || dealersHand.contains("A♦") || dealersHand.contains("A♠") || dealersHand.contains("A♥")) && dealerScore < 11 &&
                !dealersHand.get(dealersHand.size() - 1).matches("A[♣♦♠♥]")) {
            System.out.println("\nDealer score: " + dealerScore + " or " + (dealerScore + 10));
        } else {
            System.out.println("\nDealer score: " + dealerScore);
        }
    }

    public void chooseHitOrStand() {
        System.out.println("Hit or Stand: ");
        Scanner scanner = InputScanner.useScanner();
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("hit")) {
            chooseHit();
            if (playerScore > 21) {
                winOrLose();
                playAgain();
            } else {
                chooseHitOrStand();
            }

        } else if (input.equalsIgnoreCase("stand")) {
            if ((playersHand.contains("A♣") || playersHand.contains("A♦") || playersHand.contains("A♠") || playersHand.contains("A♥")) && playerScore < 11) {
                playerScore += 10;
            }
            while (dealerScore < 17) {
                if ((dealersHand.contains("A♣") || dealersHand.contains("A♦") || dealersHand.contains("A♠") || dealersHand.contains("A♥")) && dealerScore == 11) {
                    dealerScore = 21;
                } else if((dealersHand.contains("A♣") || dealersHand.contains("A♦") || dealersHand.contains("A♠") || dealersHand.contains("A♥")) && dealerScore < 11) {
                    dealerScore += 9;
                }
                chooseStand();
            }
            winOrLose();
            playAgain();
        } else {
            System.out.println("Invalid input.");
            chooseHitOrStand();
        }
    }

    public void chooseHit() {
        dashedLine();
        dealPlayersHand();
        showPlayersHand();
        showRoundStats();
        showDealerHand();
        dashedLine();
    }

    public void chooseStand() {
        dashedLine();
        showPlayersHand();
        dealDealersHand();
        showRoundStats();
        showDealerHand();
        dashedLine();
    }

    public void winOrLose() {

        if (playerScore > 21) {
            System.out.println("\nYou lose!");
        } else if (playerScore == dealerScore) {
            System.out.println("\nYour scores are tied, bets are returned");
            playerMoney += currentBet;
        } else if (dealerScore > 21) {
            System.out.println("\nDealer has bust! You win!");
            playerMoney += currentBet * 2;
        } else if (21 - playerScore < 21 - dealerScore) {
            System.out.println("\nYou win " + currentBet * 2 + "!");
            playerMoney += currentBet * 2;
        } else {
            System.out.println("\nYou lose!");
        }
    }

    public void dashedLine() {
        System.out.println("\n------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void printRules() {
        super.printRules();
    }

    @Override
    public void printTitle() {
        super.printTitle();
    }

    @Override
    public void play() {
        if (playerMoney > 0) {
            placeBet();
            dashedLine();
            displayPlayerMoney();
            dealPlayersHand();
            dealPlayersHand();
            showPlayersHand();
            dealDealersHand();
            dealDealersHand();
            showRoundStats();
            showDealerHand();
            dashedLine();
            chooseHitOrStand();
        } else {
            System.out.println(" ");
        }


    }

    @Override
    public boolean playAgain() {
        playersHand.clear();
        dealersHand.clear();
        playerScore = 0;
        dealerScore = 0;
        playerIndex = 0;
        dealerIndex = 0;
        currentBet = 0;
        cardCommands.resetDeck();
        cardCommands.shuffleDeck();
        if (playerMoney > 0) {
            System.out.println("Play again? (y/n)");
            Scanner scanner = InputScanner.useScanner();
            String yOrN = scanner.nextLine();
            dashedLine();
            if (yOrN.equalsIgnoreCase("y")) {
                play();
            } else if (yOrN.equalsIgnoreCase("n")){
                System.out.println("Thanks for playing ^_^");
                return false;
            }
        } else {
            System.out.println("OUT OF MONEY! GAME OVER!");
            dashedLine();
        }

        return true;
    }
}
