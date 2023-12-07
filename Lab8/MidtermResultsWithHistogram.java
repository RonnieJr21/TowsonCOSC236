import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidtermResultsWithHistogram {
    // Move gradeCounts to a class-level variable
    private static int[] gradeCounts = new int[5];

    public static void main(String[] args) {
        System.out.println("Results from the Midterm Exam");
        System.out.println("Student            Score Grade");
        System.out.println("------------------ ----- -----");

        // Read and process scores
        processScores("Scores.txt");

        // Print histogram
        System.out.println("\nDistribution of Grades on the Midterm Exam");
        printHistogram();
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

                // Update grade counts
                updateGradeCounts(grade);
            }

            scanner.close();

            // Print row of dashes under the table
            System.out.println("------------------ ----- -----");

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

    private static void updateGradeCounts(String grade) {
        switch (grade) {
            case "A":
                gradeCounts[0]++;
                break;
            case "B":
                gradeCounts[1]++;
                break;
            case "C":
                gradeCounts[2]++;
                break;
            case "D":
                gradeCounts[3]++;
                break;
            case "F":
                gradeCounts[4]++;
                break;
        }
    }

    private static void printHistogram() {
        String[] grades = {"A", "B", "C", "D", "F"};

        for (String grade : grades) {
            System.out.printf("%s: %s%n", grade, generateAsterisks(grade));
        }
    }

    private static String generateAsterisks(String grade) {
        int index = 0;

        switch (grade) {
            case "A":
                index = 0;
                break;
            case "B":
                index = 1;
                break;
            case "C":
                index = 2;
                break;
            case "D":
                index = 3;
                break;
            case "F":
                index = 4;
                break;
        }

        // Generate asterisks based on grade count
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < gradeCounts[index]; i++) {
            asterisks.append("*");
        }

        return asterisks.toString();
    }
}