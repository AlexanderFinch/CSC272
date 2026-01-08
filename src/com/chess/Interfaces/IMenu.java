package com.chess.Interfaces;

import com.chess.Exceptions.NoChessBoardFoundException;
import com.chess.Exceptions.QuitGameException;

public interface IMenu {
        boolean validate(String option);

        String processInput(String input) throws NoChessBoardFoundException, QuitGameException;

        void printMenu();
}
