package com.example.easyguide.logic.exceptions;

public class MissingDatesException extends Exception {
    private static final long serialVersionUID = 1L;
    public MissingDatesException() {super("Missing dates"); }
    public MissingDatesException(Throwable cause) {super(cause);}
    public MissingDatesException(String message) {super(message);}
}
