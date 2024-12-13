package com.fialka.exception;

public class InvalidPasswordException extends Exception {

    private static final String message = "Invalid admin password";

    public InvalidPasswordException() {
        super(message);
    }
}