package ru.avalon.blog.exceptions;

public class RequiredDataException extends Exception {

    public RequiredDataException() {
    }

    public RequiredDataException(String message) {
        super(message);
    }
}
