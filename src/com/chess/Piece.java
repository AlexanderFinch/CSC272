package com.chess;

 public class Piece {
    public enum Type {
        P,
        r,
        n,
        b,
        q,
        k
    }

     public String getColor() {
         return color;
     }

     public void setColor(String color) {
        //if the color is not black or not white, throw an error
         this.color = color;
     }

     private String color;

    //abstract public String getType();
    //abstract public String move();
}
