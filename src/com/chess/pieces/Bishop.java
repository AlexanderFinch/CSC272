package com.chess.pieces;

import com.chess.Piece;

public class Bishop extends Piece {
    public Bishop(COLOR color) {
        super(color);
    }

    @Override
    public String toString() {
        String ret = "b";
        if(getColor() == COLOR.BLACK) ret = "B";
        return ret;
    }

    @Override
    public void move() {

    }
}
