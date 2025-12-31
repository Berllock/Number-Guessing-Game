import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Welcome to the Number Guessing Game!
                I'm thinking of a number between 1 and 100.
                You have 5 chances to guess the correct number.
                """);

        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        int attempts = selectDifficulty(sc);
        System.out.println("You have " + attempts + " attempts!");

        int usedAttempts = 0;
        boolean hit = false;

        while (usedAttempts < attempts && !hit) {
            usedAttempts++;
            System.out.println("\nAttempts " +  usedAttempts + "/" +  attempts + ": ");
            int guess = sc.nextInt();

            if (guess == secretNumber) {
                hit = true;
                System.out.println("Congratulations! You guessed the correct number in " + usedAttempts + " attempts.");
            } else if (guess > secretNumber) {
                System.out.println("Incorrect! The number is less than " + guess + ".");
            } else {
                System.out.println("Incorrect! The number is greater than " + guess + ".");
            }
        }

        sc.close();
    }

    public static int selectDifficulty(Scanner sc) {
        System.out.println("""
                Please select the difficulty level:
                1. Easy (10 chances)
                2. Medium (5 chances)
                3. Hard (3 chances)
                """);

        System.out.print("Enter your choice: ");
        int difficulty = sc.nextInt();

        int attempts = 0;
        switch (difficulty) {
            case 1:
                attempts = 10;
                break;
            case 2:
                attempts = 5;
                break;
            case 3:
                attempts = 3;
                break;
            default:
                attempts = 5;
                System.out.println("Invalid difficulty. Using medium difficulty.");

        }
        return attempts;
    }
}