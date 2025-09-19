package com.TicTacToe;

public class Game 
{

    private Player p1;
    private Player p2;
    private Board board;
    private Player current;

    public Game(Player p1, Player p2) 
    {
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board();
        this.current = p1;
    }

    public void start()
    {
        while (true) {
            board.print();
            current.makeMove(board);
            if (board.hasWinner(current.getSymbol())) {
                board.print();
                System.out.println(current.getName() + " wins!");
                break;
            }
            if (board.isFull()) 
            {
                board.print();
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }

    private void switchPlayer() 
    {
        current = (current == p1) ? p2 : p1;
    }
}

