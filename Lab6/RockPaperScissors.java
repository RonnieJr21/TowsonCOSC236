import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to Rock Paper Scissors!");

        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors, or end to finish): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("end")) {
                System.out.println("Game over. Final score:");
                System.out.println("You: " + userScore + " | Computer: " + computerScore);
                break;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            // Generate a random choice for the computer
            int computerRandom = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors
            String computerChoice = getComputerChoice(computerRandom);

            System.out.println("Computer chooses: " + computerChoice);

            // Determine the winner
            String result = determineWinner(userChoice, computerChoice);

            // Print the result
            System.out.println(result);

            // Update scores
            if (result.equals("You win")) {
                userScore++;
            } else if (result.equals("I win")) {
                computerScore++;
            }
        }

        scanner.close();
    }

    private static String getComputerChoice(int random) {
        switch (random) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return ""; // This should never happen
        }
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie";
        } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "You win";
        } else {
            return "I win";
        }
    }
}