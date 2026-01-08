package com.chess.ui;

import com.chess.Interfaces.IMenu;

public abstract class Menu implements IMenu {
    String menu = null;

    @Override
    public void printMenu() {
        System.out.print(menu);
    }
}
