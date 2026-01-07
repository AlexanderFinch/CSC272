package com.game;

import com.chess.ChessBoard;

public class Test extends ChessBoard {
     private static ChessBoard board = new ChessBoard();

     public static void main(String[] args){
         //board.loadBoard();
         //this.;

          Test test = new Test();
          String[][] board = new String[9][9];
          test.setBoard(board);
          test.movePiece("thist is the movement");
     }

     public Test(){
          super();
     }

}
