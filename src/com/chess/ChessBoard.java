package com.chess;

import com.chess.Exceptions.NoChessBoardFoundException;
import com.chess.pieces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ChessBoard {

    private static String CHESS_FILE = "chess_game.txt";
    // A constant for the board size, making the code easier to read and modify
    public static final int BOARD_SIZE = 8;

    private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];


    public ChessBoard() {
        initializeBoard();
    }

    public static void main(String[] args) {
        // 1. Method Call: Initialize the board

        ChessBoard chessBoard = new ChessBoard();

        Object p = new Knight(Piece.COLOR.BLACK);
        ((Knight) p).move();
        p.getClass().getName();

        // 2. Method Call: Display the initial board state
        System.out.println("--- Initial Board State ---");
        //chessBoard.displayBoard();

        // 4. Method Call: Display the updated board state
        System.out.println("\n--- Board State After Adding a King ---");
        //chessBoard.displayBoard();

        //chessBoard.fib(8);
    }

    /**
     * Method to initialize the chessboard with the standard starting pieces.
     * This method demonstrates creating and returning a 2D array.
     *
     * @return A 2D String array representing the starting chess board.
     */
    public void initializeBoard() {

        // Use nested loops to iterate through all squares of the 2D array
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                // Place pawns
                if (row == 1) board[row][col] = new Pawn(Piece.COLOR.BLACK); // Black Pawns
                else if (row == 6)
                    board[row][col] = new Pawn(Piece.COLOR.WHITE); // White Pawns (lowercase for white)

                    // Place other back-row pieces for black
                else if (row == 0) {
                    if (col == 0 || col == 7) board[row][col] = new Rook(Piece.COLOR.BLACK); // Rook
                    else if (col == 1 || col == 6) board[row][col] = new Knight(Piece.COLOR.BLACK); // Knight
                    else if (col == 2 || col == 5) board[row][col] = new Bishop(Piece.COLOR.BLACK); // Bishop
                    else if (col == 3) board[row][col] = new Queen(Piece.COLOR.BLACK); // Queen
                    else if (col == 4) board[row][col] = new King(Piece.COLOR.BLACK); // King
                }
                // Place other back-row pieces for white
                else if (row == 7) {
                    if (col == 0 || col == 7) board[row][col] = new Rook(Piece.COLOR.WHITE); // Rook
                    else if (col == 1 || col == 6) board[row][col] = new Knight(Piece.COLOR.WHITE); // Knight
                    else if (col == 2 || col == 5) board[row][col] = new Bishop(Piece.COLOR.WHITE); // Bishop
                    else if (col == 3) board[row][col] = new Queen(Piece.COLOR.WHITE); // Queen
                    else if (col == 4) board[row][col] = new King(Piece.COLOR.WHITE); // King
                }
            }
        }
    }

//    void loadBoard() throws NoChessBoardFoundException {
//        Piece[][] initialBoard = new String[BOARD_SIZE][BOARD_SIZE];
//
//        try(Scanner saveFile = new Scanner(new File(CHESS_FILE));) {
//            saveFile.useDelimiter("[,\\n]");
//            while(saveFile.hasNext()) {
//                for(int row = 0; row < BOARD_SIZE; row++){
//                    for(int col = 0; col < BOARD_SIZE; col++){
//                        initialBoard[row][col] = saveFile.next();
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new NoChessBoardFoundException("Unable to load the chess board!");
//        }
//
//        setBoard(initialBoard);
//    }

    public void saveBoard() {

        try (PrintWriter writer = new PrintWriter(CHESS_FILE);) {
            writer.print(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException: Cannot invoke "com.chess.Piece.toString()" because the return value of "com.chess.ChessBoard.getPiece(int, int)" is null
     * 	at com.chess.ui.ChessBoardUI.loadBoard(ChessBoardUI.java:103)
     * 	at com.chess.ui.ChessBoardUI.createAndShowGUI(ChessBoardUI.java:96)
     * 	at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:323)
     * 	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:723)
     * 	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:702)
     * 	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
     * 	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
     * 	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
     * 	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
     * 	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
     * 	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)
     */

    public Piece getPiece(int row, int col){
        return board[row][col] != null ? board[row][col] : null;
    }

    /**
     * Method to display the current state of the chessboard in the console.
     * This method takes a 2D array as a parameter and uses nested loops for iteration.
     */
    public String toString() throws NoChessBoardFoundException {
        if (board == null) {
            throw new NoChessBoardFoundException("Board was not loaded properly.");
        }
        StringBuffer boardBuff = new StringBuffer();
        // Print column headers (A-H)
        boardBuff.append("  ");
        for (char colChar = 'A'; colChar < 'A' + BOARD_SIZE; colChar++) {
            boardBuff.append(" " + colChar + " ");
        }
        boardBuff.append("\n");

        for (int row = 0; row < BOARD_SIZE; row++) {
            // Print a separator line above each row
            boardBuff.append(" +--+--+--+--+--+--+--+--+\n");
            // Print row numbers (8 down to 1)
            boardBuff.append((8 - row) + "|");

            for (int col = 0; col < BOARD_SIZE; col++) {
                // Access array elements using two indices: [row][column]
                if (board[row] == null || board[row][col] == null) {
                    boardBuff.append("  |");
                } else {
                    boardBuff.append(" " + board[row][col].toString() + "|");
                }
            }
            boardBuff.append("\n"); // Move to the next line after the row is printed
        }
        // Print the final bottom line
        boardBuff.append(" +--+--+--+--+--+--+--+--+");
        return boardBuff.toString();
    }

    /**
     * Method to add a single piece at a specific location on the board.
     * This method modifies the array passed into it directly.
     *
     * @param movement String representation of a piece movement
     */
    public void movePiece(String movement) {
        if (movement.isEmpty()) {
            System.out.println("Error: No board coordinates provided.");
            //throw new NoMovementException();
        } else if (movement.indexOf(" ") == 0) {
            System.out.println("Error: Invalid board coordinates provided.");
            //throw new NotProperMovementException();
        }

        String piece;
        String start = movement.substring(0, movement.indexOf(" "));
        String end = movement.substring(movement.indexOf(" "));
        char col = start.substring(0, 1).toUpperCase().charAt(0);
        int row = Integer.parseInt(start.substring(1));
        if (col >= 'A' && col < 'H' && row >= 0 && row < 8) {
            System.out.printf("Your character at %s is %s: ", start, board[start.charAt(0)][start.charAt(1)]);
        } /*col >= 0 && col < BOARD_SIZE) {
            board[row][col] = piece;
        } else {

        }*/
    }

    public Piece[][] getBoard() {
        return board;
    }

    public static int calculateIndex(int row, int col){
        return (row + 1) * (col + 1) -1;
    }
}