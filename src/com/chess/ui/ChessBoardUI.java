package com.chess.ui;

import com.chess.ChessBoard;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ChessBoardUI {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    private JPanel[][] boardTiles = new JPanel[ChessBoard.BOARD_SIZE][ChessBoard.BOARD_SIZE];
    //private ChessBoard board;
    private JFrame frame;

    private JMenuBar createMenuBar() {
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

    public void createAndShowGUI() {

        frame = new JFrame("Chessboard");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        // 7. Attach Menu Bar to the Frame
        frame.setJMenuBar(createMenuBar());

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(ChessBoard.BOARD_SIZE, ChessBoard.BOARD_SIZE)); // 8 rows, 8 columns

        for (int row = 0; row < ChessBoard.BOARD_SIZE; row++) {
            for (int col = 0; col < ChessBoard.BOARD_SIZE; col++) {
                //TODO show this update
                JPanel square = new MouseHelper(row, col);

                // Alternate colors: if the sum of row and column is even, use white/light color, else black/dark
                if ((row + col) % 2 == 0) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }

                boardTiles[row][col] = square;
                contentPane.add(square);
            }
        }

        frame.setVisible(true);
    }

    public void loadBoard(ChessBoard board) {
        SwingUtilities.invokeLater(() -> {
                    for (int row = 0; row < ChessBoard.BOARD_SIZE; row++) {
                        for (int col = 0; col < ChessBoard.BOARD_SIZE; col++) {
                            if (board.getPiece(row, col) != null) {
                                boardTiles[row][col].add(new JLabel(board.getPiece(row, col).toString()));
                            }
                        }
                    }
                }
        );
    }

    public void startUI() {
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    //TODO show encapsulating class for listener
    class MouseHelper extends JPanel implements MouseListener {

        int row;
        int col;
        String set;

        public MouseHelper(int row, int col) {
            this.row = row;
            this.col = col;
            this.addMouseListener(this);
            set = "this has been set;";
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clicked: row " + row + " col " + col);
            System.out.println("Clicked: e " + e.getPoint());
            System.out.println("Clicked: this " + this);
            System.out.println("Clicked: this+ " + frame.getContentPane().getComponentAt(e.getPoint()));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //System.out.println("Pressed: row " + row + " col " + col);
            System.out.println("pressed: this " + this);
            System.out.println(this == frame.getContentPane().getComponentAt(e.getPoint()));
            System.out.println("pressed: this+ " + frame.getContentPane().getComponentAt(e.getPoint()));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //TODO fix this start end, pull out and determine the right object to reference
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();

            // Get the dimensions of the container
            int cellWidth = frame.getContentPane().getWidth() / boardTiles[0].length;
            int cellHeight = frame.getContentPane().getHeight() / boardTiles.length;

            int colIndex = x / cellWidth;
            int rowIndex = y / cellHeight;
            int index = rowIndex * boardTiles[0].length + colIndex;

            // Safely get the component if it exists
            if (index < frame.getContentPane().getComponentCount()) {
                Component clickedCell = frame.getContentPane().getComponent(index);
                System.out.println("Clicked Cell Index: " + index + " (" + clickedCell.getClass().getName() + ")");
                if(clickedCell instanceof MouseHelper){
                    System.out.println("in MouseReleased - Pressed: row " + row + " col " + col +
                            "\nReleased: row " + ((MouseHelper) clickedCell).row + " col " + ((MouseHelper) clickedCell).col);
                    ;
                }
            }
//            System.out.println("released: this " + this);
//            System.out.println("released: this+ " + frame.getContentPane().getComponentAt(e.getPoint()));

//            MouseHelper panel = (MouseHelper) frame.getContentPane().getComponentAt(e.getPoint());
//            if (panel != null) {
//                int endRow = panel.row;
//                int endCol = panel.col;
//
//            }
            //endRow = r;
            //endCol = c;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            boardTiles[row][col].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            boardTiles[row][col].setBorder(BorderFactory.createEmptyBorder());
        }
    }

}

