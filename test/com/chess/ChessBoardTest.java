package com.chess;

import com.chess.pieces.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChessBoardTest {

    private Piece[][] board = {
            {
                    new Rook(Piece.COLOR.BLACK),
                    new Knight(Piece.COLOR.BLACK),
                    new Bishop(Piece.COLOR.BLACK),
                    new Queen(Piece.COLOR.BLACK),
                    new King(Piece.COLOR.BLACK),
                    new Bishop(Piece.COLOR.BLACK),
                    new Knight(Piece.COLOR.BLACK),
                    new Rook(Piece.COLOR.BLACK)
            },
            {
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
                    new Pawn(Piece.COLOR.BLACK),
            },
            {null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null,},
            {
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
                    new Pawn(Piece.COLOR.WHITE),
            },
            {
                    new Rook(Piece.COLOR.WHITE),
                    new Knight(Piece.COLOR.WHITE),
                    new Bishop(Piece.COLOR.WHITE),
                    new Queen(Piece.COLOR.WHITE),
                    new King(Piece.COLOR.WHITE),
                    new Bishop(Piece.COLOR.WHITE),
                    new Knight(Piece.COLOR.WHITE),
                    new Rook(Piece.COLOR.WHITE)
            }
    };

    private String boardString = "   A  B  C  D  E  F  G  H \n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "8| R| N| B| Q| K| B| N| R|\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "7| P| P| P| P| P| P| P| P|\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "6|  |  |  |  |  |  |  |  |\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "5|  |  |  |  |  |  |  |  |\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "4|  |  |  |  |  |  |  |  |\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "3|  |  |  |  |  |  |  |  |\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "2| p| p| p| p| p| p| p| p|\n" +
            " +--+--+--+--+--+--+--+--+\n" +
            "1| r| n| b| q| k| b| n| r|\n" +
            " +--+--+--+--+--+--+--+--+";

    @org.junit.jupiter.api.Test
    @Order(2)
    void initializeBoard() {

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initializeBoard();
        assertEquals(boardString, chessBoard.toString());
    }

    @org.junit.jupiter.api.Test
    void saveBoard() {
    }

    @Test
    @Order(1)
    void testToString() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initializeBoard();
        System.out.println(chessBoard);
    }

    @BeforeEach
    void setUp() {
    }
}