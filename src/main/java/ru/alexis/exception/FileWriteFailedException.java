package ru.alexis.exception;

public class FileWriteFailedException extends RuntimeException {

    public FileWriteFailedException(String message) {
        super(message);
    }
}
