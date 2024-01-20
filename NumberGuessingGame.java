package internship;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Step 1: Generate a random number
        Random random = new Random();
        int generatedNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100

        // Step 2: Prompt the user for input
        Scanner scanner = new Scanner(System.in);

        // Step 5: Use a loop for multiple attempts
        int attempts = 0;
        int maxAttempts = 5; // Predefined limit

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (between 1 and 100): ");
            int userGuess = scanner.nextInt();

            // Step 3: Compare the user's guess with the generated number
            // Step 4: Provide feedback on the guess
            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! Your guess is correct.");
                break; // Exit the loop if the guess is correct
            } else if (userGuess < generatedNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            attempts++;
        }

        // Display a message if the user couldn't guess the number within the limit
        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
        }

        // Close the scanner
        scanner.close();
    }
}