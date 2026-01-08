package com.chess.Exceptions;

public class NoChessBoardFoundException extends RuntimeException {
    public NoChessBoardFoundException(String message) {
        super(message);
    }
}
