import java.util.Scanner;
import java.util.Random;

public class SecretNumberGame {

  public static void main(String args[]) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Welcome to the Secret Number Game!");

      System.out.println("Player 1, please enter your name:");
      String playerOne = scan.nextLine();
      System.out.println("Player 2, please enter your name:");
      String playerTwo = scan.nextLine();

      System.out.println("Please determine the upper bound for the secret number.");
      int max = scan.nextInt();
      System.out.println("Please determine the lower bound for the secret number.");
      int min = scan.nextInt();
      Random rand = new Random();
      int secretNumber = rand.nextInt((max - min) + 1) + min;
      System.out.println("The secret number has been randomly chosen.");

      boolean isPlayerOneTurn = true;
      int numGuesses = 1;
      int maxTries = 10;

      System.out.println("Altogether, the two of you have " + maxTries + " tries to guess the secret number.");
      System.out.println("Good Luck!");

      System.out.println(playerOne + ", what do you think the secret number is?");
      int playersGuess = scan.nextInt();

      while (playersGuess != secretNumber) {
        if (numGuesses == maxTries) {
          System.out.println("Game Over. You have run out of guesses.");
          return;
        } else if (playersGuess < secretNumber) {
          System.out.println("The secret number is HIGHER than your current guess.");
        } else if (playersGuess > secretNumber) {
          System.out.println("The secret number is LOWER than your current guess.");
        }

        int triesLeft = maxTries - numGuesses;
        System.out.println("Collectively, there are " + triesLeft + " tries left.");
        numGuesses++;
        isPlayerOneTurn = !isPlayerOneTurn;

        String currentPlayer;
        if (isPlayerOneTurn == true) {
          currentPlayer = playerOne;
        } else {
          currentPlayer = playerTwo;
        }

        System.out.println(currentPlayer + ", it is your turn now. What do you think the secret number is?");
        playersGuess = scan.nextInt();
      }

      String winner;
      if (isPlayerOneTurn == true) {
        winner = playerOne;
      } else {
        winner = playerTwo;
      }

      System.out.println(
          "Congratulations, " + winner + "! You correctly guessed the secret number was " + secretNumber + "!");
      return;
    }
  }
}
