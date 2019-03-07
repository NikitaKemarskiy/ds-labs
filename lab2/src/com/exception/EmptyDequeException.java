package com.exception;

public class EmptyDequeException extends Exception {
    public EmptyDequeException() {
        super();
    }

    public EmptyDequeException(String message) {
        super(message);
    }

    public EmptyDequeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDequeException(Throwable cause) {
        super(cause);
    }

    protected EmptyDequeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}