import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MidtermExam {

    public static void main(String[] args) {
        int[] scores = readScoresFromFile("Scores.txt");

        // Print Results from the Midterm Exam
        System.out.println("Results from the Midterm Exam");

        // Assign grades, print table, and count distributions
        char[] grades = assignGrades(scores);
        printTable(scores, grades);
        int[] gradeDistribution = countGradeDistribution(grades);

        // Print Distribution of Grades
        System.out.println("\nDistribution of Grades on the Midterm Exam");

        // Print Histogram
        printHistogram(gradeDistribution);

        // Compute and print average and standard deviation
        double average = computeAverage(scores);
        double stdDeviation = computeStandardDeviation(scores, average);
        System.out.printf("\nAverage: %.1f\n", average);
        System.out.printf("Standard Deviation: %.1f\n", stdDeviation);

        // Sort the array using Merge Sort and print the median
        int[] sortedScores = mergeSort(scores);
        double median = computeMedian(sortedScores);
        System.out.printf("Median: %.1f\n", median);
    }

    // Read scores from a file and return an array
    private static int[] readScoresFromFile(String filename) {
        int[] scores = new int[20];
        try (Scanner scanner = new Scanner(new File(filename))) {
            for (int i = 0; i < scores.length && scanner.hasNext(); i++) {
                scanner.next(); // Skip last name
                scanner.next(); // Skip first name
                scores[i] = scanner.nextInt(); // Read score
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scores;
    }

    // Assign grades based on the given criteria
    private static char[] assignGrades(int[] scores) {
        char[] grades = new char[scores.length];
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (score >= 93) grades[i] = 'A';
            else if (score >= 90) grades[i] = 'A';
            else if (score >= 87) grades[i] = 'B';
            else if (score >= 83) grades[i] = 'B';
            else if (score >= 80) grades[i] = 'B';
            else if (score >= 77) grades[i] = 'C';
            else if (score >= 70) grades[i] = 'C';
            else if (score >= 67) grades[i] = 'D';
            else if (score >= 60) grades[i] = 'D';
            else grades[i] = 'F';
        }
        return grades;
    }

    // Print table with student names, scores, and grades
    private static void printTable(int[] scores, char[] grades) {
        System.out.printf("%-12s%-2s%-6s\n", "Student", "Score", "Grade");
        System.out.println("---------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-12s%-2s%-6s\n", "Student", scores[i], grades[i]);
        }
    }

    // Count grade distribution and print histogram
    private static int[] countGradeDistribution(char[] grades) {
    int[] distribution = new int[5]; // Assuming grades are A, B, C, D, F
    for (char grade : grades) {
        switch (grade) {
            case 'A': distribution[0]++; break;
            case 'B': distribution[1]++; break;
            case 'C': distribution[2]++; break;
            case 'D': distribution[3]++; break;
            case 'F': distribution[4]++; break;
        }
    }

        // Print histogram
       System.out.println("Grade Distribution Histogram:");
        char[] gradeLabels = {'A', 'B', 'C', 'D', 'F'};
            for (int i = 0; i < distribution.length; i++) {
                System.out.printf("%c: ", gradeLabels[i]);
            for (int j = 0; j < distribution[i]; j++) {
                System.out.print("*");
        }
            System.out.println();
    }

    return distribution;
}

    // Compute and return the average of scores
    private static double computeAverage(int[] scores) {
        int sum = Arrays.stream(scores).sum();
        return (double) sum / scores.length;
    }

    // Compute and return the standard deviation of scores
   private static double computeStandardDeviation(int[] scores, double average) {
    double sumOfSquaredDifferences = 0;
    for (int score : scores) {
        sumOfSquaredDifferences += Math.pow(score - average, 2);
    }
    return Math.sqrt(sumOfSquaredDifferences / scores.length);
}

    // Implement Merge Sort to sort an array of scores
    private static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    // Compute and return the median of sorted scores
    private static double computeMedian(int[] sortedScores) {
        int n = sortedScores.length;
        if (n % 2 == 0) {
            return (sortedScores[n / 2 - 1] + sortedScores[n / 2]) / 2.0;
        } else {
            return sortedScores[n / 2];
        }
    }
   private static void printHistogram(int[] gradeDistribution) {
    char[] grades = {'A', 'B', 'C', 'D', 'F'};
    for (int i = 0; i < Math.min(gradeDistribution.length, grades.length); i++) {
        System.out.print(grades[i] + ": ");
        for (int j = 0; j < gradeDistribution[i]; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

}