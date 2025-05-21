package minesweeper;

public class Game {
    private Board board;
    private boolean[][] revealed;
    private int boardSize;

    public Game(int boardSize) {
        this.boardSize = boardSize;
        board = new Board(boardSize);
        board.placeMines();
        board.calculateNumbers();
        revealed = new boolean[boardSize][boardSize];
    }

    public void start() {
        while(true) {
            Printer.printVisibleBoard(board, revealed);
            int row = InputHandler.getRow(boardSize);
            int col = InputHandler.getCol(boardSize);

            if(revealed[row][col]) continue;

            revealed[row][col] = true;

            if(board.getCell(row, col) == '*') {
                Printer.printBoard(board);
                System.out.println("BOOM! GAME OVER!");
                break;
            }

            if(board.getCell(row, col) == '0') {
                Revealer.revealEmptyCells(board, revealed, row, col);
            }

            if(WinChecker.checkWin(board, revealed)) {
                System.out.println("🎉 You won!");
                break;
            }
        }
    }
}
