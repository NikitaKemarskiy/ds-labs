package com.exception;

public class CopyingStackException extends Exception {
    public CopyingStackException() {
        super();
    }

    public CopyingStackException(String message) {
        super(message);
    }

    public CopyingStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public CopyingStackException(Throwable cause) {
        super(cause);
    }

    protected CopyingStackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
