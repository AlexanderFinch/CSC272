package com.chess.ui;

import com.chess.Exceptions.NoChessBoardFoundException;
import com.chess.Exceptions.QuitGameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GamePlayMenu extends Menu {

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
    public String processInput(String input) throws NoChessBoardFoundException, QuitGameException {
        if (!this.validate(input)) {
            System.out.println("Invalid input provided");
            return "InvalidInput";
        }

        String returnString = "";
        if (input.equalsIgnoreCase("S")) {
            //game.board.saveBoard();
            returnString = "Save";
        } else if (input.equalsIgnoreCase("N")) {
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
