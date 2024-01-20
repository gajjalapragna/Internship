package internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("java", "hangman", "programming", "computer", "algorithm");

        Random random = new Random();
        String chosenWord = wordList.get(random.nextInt(wordList.size()));
        char[] displayWord = new char[chosenWord.length()];
        Arrays.fill(displayWord, '_');

        int incorrectGuesses = 0;
        int maxIncorrectGuesses = 6;

        Scanner scanner = new Scanner(System.in);

        while (incorrectGuesses < maxIncorrectGuesses) {
            System.out.println("Current word: " + new String(displayWord));
            System.out.print("Enter a letter: ");
            char guessedLetter = scanner.next().charAt(0);

            boolean letterGuessedCorrectly = false;

            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guessedLetter) {
                    displayWord[i] = guessedLetter;
                    letterGuessedCorrectly = true;
                }
            }

            if (!letterGuessedCorrectly) {
                incorrectGuesses++;
                displayHangman(incorrectGuesses);
            }

            if (Arrays.equals(displayWord, chosenWord.toCharArray())) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                break;
            }
        }

        if (incorrectGuesses == maxIncorrectGuesses) {
            System.out.println("Sorry, you ran out of attempts. The correct word was: " + chosenWord);
        }

        scanner.close();
    }

    private static void displayHangman(int incorrectGuesses) {
        // Display hangman figure based on the number of incorrect guesses
        // You can customize this based on your preference
        System.out.println("Incorrect guesses: " + incorrectGuesses);
        // Add logic to display different parts of the hangman figure
    }
}