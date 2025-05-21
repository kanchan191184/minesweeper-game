package minesweeper;

import java.util.Random;

public class Board {

    private int boardSize;
    private char[][] board;
    private int mineCount;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        this.mineCount = boardSize;;
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void placeMines() {
        Random random = new Random();
        int placedMines = 0;

        while(placedMines < mineCount) {
            int row = random.nextInt(boardSize);
            int col = random.nextInt(boardSize);

            if(board[row][col] != '*') {
                board[row][col] = '*';
                placedMines++;
            }
        }
    }
    public void calculateNumbers() {
        for(int i =0; i <boardSize; i++) {
            for(int j=0; j <boardSize; j++) {
                if(board[i][j] != '*') {
                    int mineCount = countAdjacentMines(i, j);
                    board[i][j] = (char) (mineCount + '0');
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count  = 0;

        for(int i = row-1; i <=row +1; i++) {
            for(int j= col-1; j<=col+1; j++) {
                if(i >= 0 && i < boardSize && j >= 0 && j < boardSize) {
                    if(board[i][j] == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public int getBoardSize() {
        return boardSize;
    }

}
