package com.TicTacToe;

public class Game {
    private Player p1;
    private Player p2;
    private Player current;
    private Board board;

    public Game() {
        this.p1 = new Player("Player 1", 'X');
        this.p2 = new Player("Player 2", 'O');
        this.current = p1;
        this.board = new Board();
    }

    private void switchPlayer() {
        current = (current == p1) ? p2 : p1;
    }

    public void start() {
        while (true) {
            board.print();
            current.makeMove(board);
            if (board.hasWinner()) {
                board.print();
                System.out.println(current.getName() + " wins!");
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }
}
