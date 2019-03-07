package com.exception;

public class FullDequeException extends Exception {
    public FullDequeException() {
        super();
    }

    public FullDequeException(String message) {
        super(message);
    }

    public FullDequeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullDequeException(Throwable cause) {
        super(cause);
    }

    protected FullDequeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
