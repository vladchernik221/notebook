package com.notebook.exceptions;

/**
 * Exception for situation, when note has wrong base type
 * @author Владислав
 * @version 1.0
 */
public class NoteWrongTypeException extends Exception {
    public NoteWrongTypeException() {
    }

    public NoteWrongTypeException(String message) {
        super(message);
    }
}
