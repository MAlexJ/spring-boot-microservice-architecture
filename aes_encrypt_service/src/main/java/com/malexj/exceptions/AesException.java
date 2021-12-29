package com.malexj.exceptions;

public class AesException extends RuntimeException{

    public AesException(String message) {
        super(message);
    }

    public AesException(String message, Throwable cause) {
        super(message, cause);
    }
}
