package com.chess.model;

import com.chess.Piece;

public record Move(int startRow, int startCol, int endRow, int endCol, Piece piece, String player) {
}
