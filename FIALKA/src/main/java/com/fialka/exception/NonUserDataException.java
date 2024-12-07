package com.fialka.exception;

public class NonUserDataException extends Exception{
    private static final String message = "The specified username doesn't exist.";

    public NonUserDataException() {
        super(message);
    }
}