package minesweeper;

public class Printer {

    // ANSI escape codes for colored output

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public static void printBoard(Board board) {
        int boardSize = board.getBoardSize();
    
        System.out.print("   ");
        for(int i = 0; i < boardSize; i++) {
            System.out.print(YELLOW + (i + 1) + " ");
        }
    
        System.out.println();
    
        for(int i = 0; i < boardSize; i++) {
            System.out.printf(YELLOW + "%2d " + RESET, (i+1));
            for (int j = 0; j < boardSize; j++) {
                char cell = board.getCell(i, j);
                if(cell =='*') {
                    System.out.print(RED + cell + RESET);
                } else {
                    System.out.print(cell + " ");
                }
            }
    
            System.out.println();
        }
    }

    public static void printVisibleBoard(Board board, boolean[][] revealed) {
        // int size = revealed.length;
        int size = board.getBoardSize();

        System.out.print("   ");
        for(int i = 1; i <= size; i++)
        System.out.print(YELLOW + i + " ");
        System.out.println();

        for(int i = 0; i < size; i++) {
            System.out.printf(YELLOW + "%2d" + RESET, i + 1);
            for(int j = 0; j < size; j++) {
                if(revealed[i][j]) {
                    char cell = board.getCell(i, j);
                    System.out.print( " " + colorCell(cell));
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
    }

       private static String colorCell(char cell) {
        switch(cell) {
            case '0': return GREEN + cell + RESET;
            case '1': return BLUE + cell + RESET;
            case '2': return GREEN + cell + RESET;
            case '3': return RED + cell + RESET;
            case '4': return PURPLE + cell + RESET;
            case '5': return CYAN + cell + RESET;
            case '*': return RED + cell + RESET;
            default: return cell + "";
        }
    }
}
