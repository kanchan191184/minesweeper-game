package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

   private static Scanner scanner = new Scanner(System.in);

   public static int getBoardSize() {
    return getInput("Enter the board size (minimum 5, maximum 20): ", 5, 20);
   }

    //  public static int getMineCount(int boardSize) {
    //     return getInput("Enter the number of mines (minimum 1, maximum " + (boardSize * boardSize - 1) + "): ", 1, boardSize * boardSize - 1);
    // }
    public static int getRow(int boardSize) {
        return getInput("Enter row (1-" + boardSize + "): ", 1,boardSize) - 1;
    }

    public static int getCol(int boardSize) {
        return getInput("Enter column (1-"+ boardSize + "): ",1, boardSize) - 1;
    }


    private static int getInput(String prompt, int min, int max) {
      while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                } else {
                    return input; // Adjust for zero-based index
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
    public static void closeScanner() {
        scanner.close();
    }
}
