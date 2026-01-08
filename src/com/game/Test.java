package com.game;

import com.chess.ChessBoard;

public class Test extends ChessBoard {

     public static void main(String[] args){


          Test test = new Test();
          test.movePiece("this is the movement");

          test.initializeBoard();


     }

     public Test(){
          super();
     }

}
