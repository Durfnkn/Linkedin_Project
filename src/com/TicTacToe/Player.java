package com.TicTacToe;

import java.util.Scanner;

public class Player
{

    private String name;
    private char symbol;
    private Scanner sc = new Scanner(System.in);

    public Player(String name, char symbol)
    {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() 
    {
        return name;
    }

    public char getSymbol()
    {
        return symbol;
    }

    public void makeMove(Board board)
    {
        while (true) 
        {
            System.out.println(name + " (" + symbol + ") enter row and column (0-2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (board.placeMark(r, c, symbol)) break;
            System.out.println("Invalid move! Try again.");
        }
    }
}

