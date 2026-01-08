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

    public void createAndShowGUI(ChessBoard board) {
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
                if(board.getPiece(row, col)!= null) {
                    JLabel label = new JLabel(board.getPiece(row, col).toString());
                    square.add(label);
                }
                // Alternate colors: if the sum of row and column is even, use white/light color, else black/dark
                if ((row + col) % 2 == 0) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }
                contentPane.add(square);
            }
        }

        frame.setVisible(true);
    }

    public void startUI(ChessBoard board){
        SwingUtilities.invokeLater(() -> createAndShowGUI(board));
    }

    public static void main(String[] args) {
        // Ensure the GUI creation runs on the Event Dispatch Thread (EDT)
        ChessBoardUI ui = new ChessBoardUI();
        ChessBoard board = new ChessBoard();
        ui.startUI(board);
    }
}

