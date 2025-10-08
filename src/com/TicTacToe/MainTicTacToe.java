package com.TicTacToe;

public class MainTicTacToe {
    public static void main(String[] args) {
        System.out.println("🎮 Welcome to Tic Tac Toe Game!");
        System.out.println("================================");

        Game game = new Game();
        game.start();

        System.out.println("================================");
        System.out.println("👋 Thanks for playing Tic Tac Toe!");
    }
}
