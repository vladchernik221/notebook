package com.notebook.exceptions;

/**
 * Exception for situation, when note is already exist
 * @author Владислав
 * @version 1.0
 */
public class NoteAlreadyExist extends Exception {
    public NoteAlreadyExist() {
    }

    public NoteAlreadyExist(String message) {
        super(message);
    }
}
