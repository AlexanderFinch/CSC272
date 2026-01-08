package com.chess.pieces;

import com.chess.Piece;

public class Knight extends Piece {
    public Knight(COLOR color) {
        super(color);
    }

    @Override
    public String toString() {

        String ret = "n";
        if(getColor() == COLOR.BLACK) ret = "N";
        return ret;
    }

    @Override
    public void move() {

    }
}
