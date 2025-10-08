package com.TicTacToe;

public class Board {
    private static final char EMPTY = ' ';
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = EMPTY;
    }

    public boolean placeMark(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || grid[row][col] != EMPTY)
            return false;
        grid[row][col] = symbol;
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == EMPTY)
                    return false;
        return true;
    }

    public boolean hasWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != EMPTY && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2])
                return true;
            if (grid[0][i] != EMPTY && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])
                return true;
        }
        // Check diagonals
        if (grid[0][0] != EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
            return true;
        if (grid[0][2] != EMPTY && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])
            return true;

        return false;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}
