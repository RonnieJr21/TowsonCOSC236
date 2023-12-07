import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidtermResults {
    public static void main(String[] args) {
        System.out.println("Results from the Midterm Exam");
        System.out.println("Student            Score Grade");
        System.out.println("------------------ ----- -----");

        // Read and process scores
        processScores("Scores.txt");
    }

    private static void processScores(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNext()) {
                String lastName = scanner.next();
                String firstName = scanner.next();
                int score = scanner.nextInt();
                String grade = assignGrade(score);

                // Print formatted result
                System.out.printf("%-18s %5d %5s%n", lastName + ", " + firstName, score, grade);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
    }

    private static String assignGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}