package minesweeper;

public class App {
    public static void main(String[] args) {

        int boardSize = InputHandler.getBoardSize();

        Game game = new Game(boardSize);
        game.start();

        InputHandler.closeScanner();
    }
}
