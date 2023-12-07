import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("Multiplication Table");

        int width = getTableDimension("width");
        int height = getTableDimension("height");

        // Generate and print multiplication table
        int[][] multiplicationTable = generateMultiplicationTable(width, height);
        printMultiplicationTable(multiplicationTable);
    }

    private static int getTableDimension(String dimension) {
        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            System.out.print("How " + dimension + " would you like the table? ");
            String input = scanner.nextLine();

            try {
                value = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        return value;
    }

    private static int[][] generateMultiplicationTable(int width, int height) {
        int[][] table = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }

    private static void printMultiplicationTable(int[][] table) {
        int maxLength = computeMaxLength(table);

        // Print table
        printTableTopBorder(table[0].length, maxLength);
        for (int i = 0; i < table.length; i++) {
            System.out.print("|");
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%" + (maxLength + 2) + "d|", table[i][j]);
            }
            System.out.println();
            printTableLine(table[0].length, maxLength);
        }
        printTableBottomBorder(table[0].length, maxLength);
    }

    private static void printTableTopBorder(int columns, int maxLength) {
        System.out.print("+");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < maxLength + 2; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    private static void printTableLine(int columns, int maxLength) {
        System.out.print("|");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < maxLength + 2; j++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
    }

    private static void printTableBottomBorder(int columns, int maxLength) {
        System.out.print("+");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < maxLength + 2; s j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    private static int computeMaxLength(int[][] table) {
        int lastValue = table[table.length - 1][table[0].length - 1];
        return Integer.toString(lastValue).length();
    }
}