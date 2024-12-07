package com.fialka.exception;

public class UserExistException extends Exception {
    private static final String message = "A user with the same data is already exists.";

    public UserExistException() {
        super(message);
    }
}