package com.chess;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessGame {

    private static ChessGame game = new ChessGame();

    private enum mode{
        INVALID_INPUT
    }

    private StartMenu startMenu;
    private GamePlayMenu gamePlayMenu;
    private ChessBoard board;

    public static void main(String[] args) {
        run();
    }

    static public void run() {
        try {
            getMenuInput(game.startMenu);
            getMenuInput(game.gamePlayMenu);
            //play();
        } catch (FileNotFoundException | ChessBoard.NoChessBoardFoundException | QuitGameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---***--- Thanks for playing! ---***---");
    }

    public ChessGame() {
        startMenu = new StartMenu();
        gamePlayMenu = new GamePlayMenu();
        board = new ChessBoard();
    }

    static public void getMenuInput(Menu inMenu) throws FileNotFoundException, ChessBoard.NoChessBoardFoundException, QuitGameException {
        Scanner in = new Scanner(System.in);

        Menu menu = inMenu;
        menu.printMenu();
        String input = in.next();
        while (menu.processInput(input).equalsIgnoreCase("InvalidInput")) {
            menu.printMenu();
            input = in.next();
        }
    }

    public static void play() throws FileNotFoundException, ChessBoard.NoChessBoardFoundException, QuitGameException {

        game.board.displayBoard();
        game.gamePlayMenu.printMenu();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        while (game.gamePlayMenu.processInput(input).equalsIgnoreCase("InvalidInput")) {
            game.board.displayBoard();
            game.gamePlayMenu.printMenu();
        }
    }

    private interface IMenu {
        boolean validate(String option);

        String processInput(String input) throws ChessBoard.NoChessBoardFoundException, QuitGameException;

        void printMenu();
    }

    private abstract class Menu implements IMenu {
        String menu = null;

        @Override
        public void printMenu() {
            System.out.print(menu);
        }

        void newMethod(){}
    }

    private class StartMenu extends Menu {

        public StartMenu() {
            this.menu = "Chess Game Start menu:\n" +
                    "  * New game (N)\n" +
                    "  * Load a game (L)\n" +
                    "  * Quit (Q)\n" +
                    ">  ";

        }

        @Override
        public void newMethod(){
            System.out.println("THis is a new method");
        }


        @Override
        public boolean validate(String option) {
            return option.equalsIgnoreCase("N")
                    || option.equalsIgnoreCase("L")
                    || option.equalsIgnoreCase("Q");
        }

        @Override
        public String processInput(String input) throws ChessBoard.NoChessBoardFoundException, QuitGameException {
            if (!this.validate(input)) {
                System.out.println("Invalid input provided!");
                return "InvalidInput";
            }

            this.newMethod();

            String returnString = "";
            if (input.equalsIgnoreCase("N")) {
                game.board.initializeBoard();
                returnString = "New";
            } else if (input.equalsIgnoreCase("L")) {
                game.board.loadBoard();
                returnString = "Load";
            } else if (input.equalsIgnoreCase("Q")) {
                throw new QuitGameException();
            }

            return returnString;
        }
    }

    private class GamePlayMenu extends Menu {

        public GamePlayMenu() {
            this.menu = "Your move!\n" +
                    "  * To play, enter the column+row of the piece you want to move and the column+row of the space you want to move it to, (ex. \"A2 B4\")\n" +
                    "  * Save game (S), Load game (L), New game (N), Quit (Q)\n" +
                    ">  ";
        }

        @Override
        public boolean validate(String option) {
            String regex = "[A-H]{1}[1-8]{1}[ ]{1}[A-H]{1}[1-8]{1}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(option);

            return option.equalsIgnoreCase("N")
                    || option.equalsIgnoreCase("L")
                    || option.equalsIgnoreCase("S")
                    || option.equalsIgnoreCase("Q")
                    || matcher.find();
        }

        @Override
        public String processInput(String input) throws ChessBoard.NoChessBoardFoundException, QuitGameException {
            if (!this.validate(input)) {
                System.out.println("Invalid input provided");
                return "InvalidInput";
            }

            String returnString = "";
            if (input.equalsIgnoreCase("S")) {
                game.board.saveBoard();
                returnString = "Save";
            } else if (input.equalsIgnoreCase("N")) {
                game.board.initializeBoard();
                returnString = "New";
            } else if (input.equalsIgnoreCase("L")) {
                game.board.loadBoard();
                returnString = "Load";
            } else if (input.equalsIgnoreCase("Q")) {
                throw new QuitGameException();
            }
            return returnString;
        }
    }

    private class ExitMenu extends Menu{

        @Override
        public boolean validate(String option) {
            return false;
        }

        @Override
        public String processInput(String input) throws ChessBoard.NoChessBoardFoundException, QuitGameException {
            return null;
        }
    }

    private class QuitGameException extends Throwable {
    }
}
