package minesweeper;

public class WinChecker {
    public static boolean checkWin(Board board, boolean[][] revealed) {
        int size = board.getBoardSize();
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!revealed[i][j] && board.getCell(i, j) != '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
