package minesweeper;

public class Revealer {
    public static void revealEmptyCells(Board board, boolean[][] revealed, int row, int col) {
        int size = board.getBoardSize();
        
        if(row < 0 || row >= size || col < 0 || col >= size) return;
        if(revealed[row][col]) return;
        
        if(board.getCell(row, col) == '*') return;

        revealed[row][col] = true;

        if(board.getCell(row, col) == '0') {
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    revealEmptyCells(board, revealed, row + i, col + j);
                }
            }
        }
    }
}
