package lab1;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        new Game(2).startGame();
    }

    public Random random = new Random();
    public Scanner scanner = new Scanner(System.in);
    public int winThreshold = 2;

    public int playerWins = 0;
    public int computerWins = 0;

    public Game(int winThreshold) {
        this.winThreshold = winThreshold;
    }

    public void startGame() {
        while(Math.max(playerWins, computerWins) < winThreshold) {
            playRound();
        }

        System.out.println("The " + (playerWins > computerWins ? "Player" : "Computer") + " has won.");
    }

    public void playRound() {
        int playerInput = getPlayerAction();
        int computerInput = random.nextInt(3);

        System.out.print("The computer is " + getActionName(computerInput) + ". You are " + getActionName(playerInput) + ". ");

        switch(compareAction(playerInput, computerInput)) {
            case -1:
                System.out.println("You lose.");
                computerWins++;
                break;
            case 0:
                System.out.println("It's a draw.");
                break;
            case 1:
                System.out.println("You win.");
                playerWins++;
                break;
        }
    }

    public int getPlayerAction() {
        int input = -1;

        while(input < 0 || input > 2) {
            System.out.print("\nscissor (0), rock (1), paper (2): ");
            input = scanner.nextInt();
        }

        return input;
    }

    public static int compareAction(int player, int computer) {
        int key = player - computer;
        return key == 0 ? 0 : key == 1 || key == -2 ? 1 : -1; // Witchcraft
    }

    public static String getActionName(int action) {
        switch(action) {
            case 0:
                return "Scissor";
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            default:
                return "Error";
        }
    }
}
