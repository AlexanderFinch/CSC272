package com.chess.ui;

import com.chess.ChessBoard;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ChessBoardUI {

    private JPanel[][] boardTiles = new JPanel[ChessBoard.BOARD_SIZE][ChessBoard.BOARD_SIZE];
    private ChessBoard board;

    private JMenuBar createMenuBar(){
        // 1. Create the Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // 2. Create Menus
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt+F shortcut

        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // 3. Create Menu Items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add an action to the Exit item
        exitItem.addActionListener(e -> System.exit(0));

        // 4. Create a Submenu
        JMenu exportSubMenu = new JMenu("Export As...");
        exportSubMenu.add(new JMenuItem("PDF"));
        exportSubMenu.add(new JMenuItem("PNG"));

        // 5. Assemble the "File" Menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator(); // Adds a horizontal line divider
        fileMenu.add(exportSubMenu); // Add submenu to menu
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // 6. Add Menus to the Menu Bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Add "glue" to push the Help menu to the far right
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(helpMenu);

        return menuBar;
    }

    public void createAndShowGUI( ) {

        JFrame frame = new JFrame("Chessboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // 7. Attach Menu Bar to the Frame
        frame.setJMenuBar(createMenuBar());

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(8, 8)); // 8 rows, 8 columns

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel();
                square.add(new JPanel());
                // Alternate colors: if the sum of row and column is even, use white/light color, else black/dark
                if ((row + col) % 2 == 0) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }
                contentPane.add(square);
                boardTiles[row][col] = square;
            }
        }

        frame.setVisible(true);
    }

    public void loadBoard(ChessBoard board){

    }

    public void startUI(ChessBoard board){
        this.board = board;
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }
}

