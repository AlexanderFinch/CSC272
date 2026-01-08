package com.chess.pieces;

import com.chess.Piece;

public class Pawn extends Piece {
    public Pawn(COLOR color) {
        super(color);
    }

    @Override
    public String toString() {

        String ret = "p";
        if(getColor() == COLOR.BLACK) ret = "P";
        return ret;
    }

    @Override
    public void move() {

    }
}
