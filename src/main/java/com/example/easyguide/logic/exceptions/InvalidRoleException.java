package com.example.easyguide.logic.exceptions;

public class InvalidRoleException extends Exception{
    private static final long serialVersionUID = 1L;
    public InvalidRoleException() {super("Role is wrong"); }
    public InvalidRoleException(Throwable cause) {super(cause);}
    public InvalidRoleException(String message) {super(message);}
}
