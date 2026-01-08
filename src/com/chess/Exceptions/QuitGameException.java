package com.chess.Exceptions;

public class QuitGameException extends RuntimeException {
    public QuitGameException(String message) {
        super(message);
    }
}
