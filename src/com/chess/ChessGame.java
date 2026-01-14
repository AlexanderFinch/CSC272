package com.chess;

import com.chess.ui.ChessBoardUI;
import com.game.Game;

public class ChessGame extends Game {

    private final ChessBoard board;
    private final ChessBoardUI ui;

    public ChessGame() {
        ui = new ChessBoardUI();
        board = new ChessBoard();
    }

    public void run() {
        ui.startUI(board);
    }
}
