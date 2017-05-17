package com.notebook.exceptions;

/**
 * Exception for situation, when note with such title do not exist
 * @author Владислав
 * @version 1.0
 */
public class NoteNotFoundException extends Exception{
    public NoteNotFoundException() {
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}
