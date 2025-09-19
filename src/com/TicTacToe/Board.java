package com.TicTacToe;

public class Board {

    private char[][] grid = new char[3][3];

    public Board() 
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grid[i][j] = ' ';
            }
        }
    }

    public void print()
    {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    public boolean placeMark(int row, int col, char symbol)
    {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (grid[row][col] != ' ') return false;
        grid[row][col] = symbol;
        return true;
    }

    public boolean hasWinner(char symbol)
    {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol)
            || (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    public boolean isFull()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') return false;
            }
        }
        return true;
    }
}

