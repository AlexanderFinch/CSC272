package com.chess;

import com.chess.Interfaces.Moveable;
import com.chess.Interfaces.Taken;
import com.chess.pieces.King;
import com.chess.pieces.Queen;
import com.chess.pieces.Rook;

public abstract class Piece implements Comparable<Piece>, Moveable, Taken {


    private final COLOR color;
    private String position;

    public enum COLOR {
        BLACK,
        WHITE
    }

    public Piece(COLOR color) {
        this.color = color;
    }

    @Override
    public int compareTo(Piece piece) {
        int ret = -1;
        if (this.getClass() == piece.getClass()) {
            ret = 0;
        }
        return ret;
    }

    @Override
    public void taken() {
        //remove from play
    }

    public static void main(String[] args) {
        Piece king = new King(COLOR.BLACK);
        Piece queen = new Queen(COLOR.WHITE);
        Piece rook = new Rook(COLOR.BLACK);
        Piece[] pieces = {
                king,
                queen,
                rook
        };

        for (Piece piece : pieces) {
            System.out.println("Piece type: " + piece.getClass().getName());
            if (piece.compareTo(rook) == 0) {
                System.out.println("They are the same pieces");
            }
        }

        Moveable[] movables = {
                king,
                queen,
                rook
        };

        for (Moveable piece : movables) {
            System.out.println("Piece type: " + piece.getClass().getName());
            piece.move();
        }

        Taken[] takens = {
                king,
                queen,
                rook
        };

        for (Taken piece : takens) {
            System.out.println("Piece type: " + piece.getClass().getName());
            piece.taken();
        }
    }

    public COLOR getColor() {
        return color;
    }

    public abstract String toString();
}
