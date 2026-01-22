package com.chess;

import com.chess.model.Move;
import com.chess.ui.ChessBoardUI;
import com.game.Game;

public class ChessGame extends Game {

    private final ChessBoard board;
    private final ChessBoardUI ui;
    private Move[] moves;

    public ChessGame() {
        ui = new ChessBoardUI();
        board = new ChessBoard();
    }

    public void run() {
        board.initializeBoard();
        ui.startUI();
        ui.loadBoard(board);
    }
}
