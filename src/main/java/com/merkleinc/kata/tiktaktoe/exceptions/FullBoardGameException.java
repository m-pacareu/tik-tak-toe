package com.merkleinc.kata.tiktaktoe.exceptions;

public class FullBoardGameException extends RuntimeException{
    public FullBoardGameException(String message) {
        super(message);
    }
}
