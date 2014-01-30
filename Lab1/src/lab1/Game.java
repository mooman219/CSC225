package lab1;

import java.util.Random;
import java.util.Scanner;

public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game().startGame();
    }

    public Random random = new Random();
    public Scanner scanner = new Scanner(System.in);
    public int playerWins = 0;
    public int computerWins = 0;

    public Game() {}

    public void startGame() {
        while (playerWins < 2 && computerWins < 2) {
            playRound();
        }
        System.out.println("The " + (playerWins > computerWins ? "Player" : "Computer") + " has won.");
    }

    public void playRound() {
        int playerInput = input();
        int computerInput = random.nextInt(3);
        System.out.print("The computer is " + getActionName(computerInput) + ". You are " + getActionName(playerInput) + ". ");
        switch (Integer.compare(playerInput, computerInput)) {
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

    public String getActionName(int action) {
        switch (action) {
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

    public int input() {
        int input = -1;
        while (input < 0 || input > 2) {
            System.out.print("\nscissor (0), rock (1), paper (2): ");
            input = scanner.nextInt();
        }
        return input;
    }
}
