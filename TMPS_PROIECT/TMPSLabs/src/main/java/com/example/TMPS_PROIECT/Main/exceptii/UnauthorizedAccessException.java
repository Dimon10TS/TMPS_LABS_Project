package com.example.TMPS_PROIECT.Main.exceptii;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
