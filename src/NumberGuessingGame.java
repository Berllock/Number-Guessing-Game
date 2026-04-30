import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("""
        Welcome to the Number Guessing Game!
        I'm thinking of a number between 1 and 100.
        """);

        Random generator = new Random();
        int secretNumber = generator.nextInt(100) + 1;

        int numberTrials = selectDifficulty(sc);
        int actualTrial = 0;
        boolean hit = false;

        System.out.println("You have " + numberTrials + " trials.");

        while (actualTrial < numberTrials && !hit) {

            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            if (guess == secretNumber) {
                hit = true;
            } else if (guess < secretNumber) {
                System.out.printf("Incorrect! The number is greater than %d\n", guess);
            } else {
                System.out.printf("Incorrect! The number is less than %d\n", guess);
            }

            actualTrial++;
        }

        if (!hit) {
            System.out.printf("You lose! The correct number was %d\n", secretNumber);
        } else {
            System.out.printf("Congratulations! You guessed the correct number in %d attempts!\n", actualTrial);
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

        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();

        return switch (choice) {
            case 1 -> 10;
            case 2 -> 5;
            case 3 -> 3;
            default -> {
                System.out.println("Invalid choice. Defaulting to Medium (5 chances).");
                yield 5;
            }
        };
    }



}
