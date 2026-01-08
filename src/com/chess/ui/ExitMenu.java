package com.chess.ui;

import com.chess.Exceptions.NoChessBoardFoundException;
import com.chess.Exceptions.QuitGameException;

public class ExitMenu extends Menu {

    @Override
    public boolean validate(String option) {
        return false;
    }

    @Override
    public String processInput(String input) throws NoChessBoardFoundException, QuitGameException {
        return null;
    }
}
