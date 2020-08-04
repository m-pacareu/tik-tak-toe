package com.merkleinc.kata.tiktaktoe.exceptions;

public class NotEmptyCellException extends RuntimeException{
    public NotEmptyCellException(String message) {
        super(message);
    }
}
