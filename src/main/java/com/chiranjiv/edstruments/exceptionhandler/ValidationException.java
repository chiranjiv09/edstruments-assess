package com.chiranjiv.edstruments.exceptionhandler;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
