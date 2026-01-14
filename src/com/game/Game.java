package com.game;

import com.chess.ChessGame;

public abstract class Game {

    public static void main(String[] args) {

        Game game = new ChessGame();
        game.run();

    }

    public abstract void run();
}
