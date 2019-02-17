package com.exception;

public class InvalidCapacityException extends Exception {
    public InvalidCapacityException() {
        super();
    }

    public InvalidCapacityException(String message) {
        super(message);
    }

    public InvalidCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCapacityException(Throwable cause) {
        super(cause);
    }

    protected InvalidCapacityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
