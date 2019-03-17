package com.exception;

public class InvalidItemException extends Exception {
    public InvalidItemException() {
        super();
    }

    public InvalidItemException(String message) {
        super(message);
    }

    public InvalidItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidItemException(Throwable cause) {
        super(cause);
    }

    protected InvalidItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
