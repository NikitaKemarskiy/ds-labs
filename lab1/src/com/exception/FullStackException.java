package com.exception;

public class FullStackException extends Exception {
    public FullStackException() {
        super();
    }

    public FullStackException(String message) {
        super(message);
    }

    public FullStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullStackException(Throwable cause) {
        super(cause);
    }

    protected FullStackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
