package com.chess;

import com.chess.Exceptions.NoChessBoardFoundException;
import com.chess.Exceptions.QuitGameException;
import com.chess.ui.GamePlayMenu;
import com.chess.ui.Menu;
import com.chess.ui.StartMenu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessGame {

    private static ChessGame game = new ChessGame();

    private enum mode{
        INVALID_INPUT
    }

    private StartMenu startMenu;
    private GamePlayMenu gamePlayMenu;
    private ChessBoard board;

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.run();
    }

    public void run() {
        try {
            //setup UI
            getMenuInput(game.startMenu);
            getMenuInput(game.gamePlayMenu);
            //play();
        } catch (FileNotFoundException | NoChessBoardFoundException | QuitGameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---***--- Thanks for playing! ---***---");
    }

    public ChessGame() {
        startMenu = new StartMenu();
        gamePlayMenu = new GamePlayMenu();
        board = new ChessBoard();
    }

    static public void getMenuInput(Menu inMenu) throws FileNotFoundException, NoChessBoardFoundException {
        Scanner in = new Scanner(System.in);

        Menu menu = inMenu;
        menu.printMenu();
        String input = in.next();
        while (menu.processInput(input).equalsIgnoreCase("InvalidInput")) {
            menu.printMenu();
            input = in.next();
        }
    }

    public static void play() throws FileNotFoundException, NoChessBoardFoundException {

        //game.board.displayBoard();
        game.gamePlayMenu.printMenu();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        while (game.gamePlayMenu.processInput(input).equalsIgnoreCase("InvalidInput")) {
            //game.board.displayBoard();
            game.gamePlayMenu.printMenu();
        }
    }
}
