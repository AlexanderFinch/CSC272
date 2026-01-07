package com.chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ChessBoard {

    private static String CHESS_FILE = "chess_game.txt";
    // A constant for the board size, making the code easier to read and modify
    private static final int BOARD_SIZE = 8;
    // A 2D array of Strings to store the chess pieces (e.g., "P", "R", " ", etc.)
    private String[][] board;
    private HashMap<String, Piece> pieces = new HashMap<>();
    private LinkedList<String> pieceList = new LinkedList<>();
    private ArrayList<String> list = new ArrayList<>();

    public ChessBoard() {
    }

    public static void main(String[] args) {
        // 1. Method Call: Initialize the board

        ChessBoard chessBoard = new ChessBoard();

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
        String[][] initialBoard = new String[BOARD_SIZE][BOARD_SIZE];

        // Use nested loops to iterate through all squares of the 2D array
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                // Place pawns
                if (row == 1) {
                    initialBoard[row][col] = "P"; // Black Pawns
                } else if (row == 6) {
                    initialBoard[row][col] = "p"; // White Pawns (lowercase for white)
                }
                // Place other back-row pieces
                else if (row == 0 || row == 7) {
                    String pieceType = "";
                    if (col == 0 || col == 7) pieceType = "R"; // Rook
                    else if (col == 1 || col == 6) pieceType = "N"; // Knight
                    else if (col == 2 || col == 5) pieceType = "B"; // Bishop
                    else if (col == 3) pieceType = "Q"; // Queen
                    else if (col == 4) pieceType = "K"; // King

                    // Assign the pieces based on the row color
                    if (row == 7) {
                        initialBoard[row][col] = pieceType.toLowerCase(); // White
                    } else {
                        initialBoard[row][col] = pieceType; // Black
                    }
                }
                // Fill empty squares with a space
                if (initialBoard[row][col] == null) {
                    initialBoard[row][col] = " ";
                }
            }
        }
        setBoard(initialBoard);
    }

    void loadBoard() throws NoChessBoardFoundException {
        String[][] initialBoard = new String[BOARD_SIZE][BOARD_SIZE];

        try(Scanner saveFile = new Scanner(new File(CHESS_FILE));) {
            saveFile.useDelimiter("[,\\n]");
            while(saveFile.hasNext()) {
                for(int row = 0; row < BOARD_SIZE; row++){
                    for(int col = 0; col < BOARD_SIZE; col++){
                        initialBoard[row][col] = saveFile.next();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new NoChessBoardFoundException("Unable to load the chess board!");
        }

        setBoard(initialBoard);
    }

    public void saveBoard() {

        try(PrintWriter writer = new PrintWriter(CHESS_FILE);) {
            //writer = new PrintWriter(CHESS_FILE);
            for(int row = 0; row < BOARD_SIZE; row++ ){
                for(int col = 0; col < BOARD_SIZE; col++){
                    if(col > 0 && col < BOARD_SIZE){
                        writer.print(",");
                    }
                    writer.print(board[row][col]);
                }
                writer.print("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to display the current state of the chessboard in the console.
     * This method takes a 2D array as a parameter and uses nested loops for iteration.
     */
    protected void displayBoard() throws NoChessBoardFoundException {
        if(board == null){
            throw new NoChessBoardFoundException("Board was not loaded properly.");
        }
        // Print column headers (A-H)
        System.out.print("  ");
        for (char colChar = 'A'; colChar < 'A' + BOARD_SIZE; colChar++) {
            System.out.print(" " + colChar + " ");
        }
        System.out.println();

        for (int row = 0; row < BOARD_SIZE; row++) {
            // Print a separator line above each row
            System.out.println(" +--+--+--+--+--+--+--+--+");
            // Print row numbers (8 down to 1)
            System.out.print((8 - row) + "|");

            for (int col = 0; col < BOARD_SIZE; col++) {
                // Access array elements using two indices: [row][column]
                System.out.print(" " + board[row][col] + "|");
            }
            System.out.println(); // Move to the next line after the row is printed
        }
        // Print the final bottom line
        System.out.println(" +--+--+--+--+--+--+--+--+");
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

    public void setBoard(String[][] board) {
        // if the array length is greater than 8 return an error
        this.board = board;
    }

    public class NoChessBoardFoundException extends Throwable {
        public NoChessBoardFoundException(String s) {
            super(s);
        }
    }
}