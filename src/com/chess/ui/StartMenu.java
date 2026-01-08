package com.chess.ui;

import com.chess.Exceptions.NoChessBoardFoundException;
import com.chess.Exceptions.QuitGameException;

public class StartMenu extends Menu {

    public StartMenu() {
        this.menu = "Chess Game Start menu:\n" +
                "  * New game (N)\n" +
                "  * Load a game (L)\n" +
                "  * Quit (Q)\n" +
                ">  ";

    }

    @Override
    public boolean validate(String option) {
        return option.equalsIgnoreCase("N")
                || option.equalsIgnoreCase("L")
                || option.equalsIgnoreCase("Q");
    }

    @Override
    public String processInput(String input) throws NoChessBoardFoundException, QuitGameException {
        if (!this.validate(input)) {
            System.out.println("Invalid input provided!");
            return "InvalidInput";
        }

        String returnString = "";
        if (input.equalsIgnoreCase("N")) {
            //game.board.initializeBoard();
            returnString = "New";
        } else if (input.equalsIgnoreCase("L")) {
            //game.board.loadBoard();
            returnString = "Load";
        } else if (input.equalsIgnoreCase("Q")) {
            throw new QuitGameException("Quit");
        }

        return returnString;
    }
}
