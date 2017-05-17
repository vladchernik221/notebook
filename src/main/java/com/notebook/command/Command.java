package com.notebook.command;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.exceptions.NoteNotFoundException;
import com.notebook.exceptions.NoteWrongTypeException;

/**
 * Pattern Command
 * @author Владислав
 * @version 1.0
 */
public interface Command {
    /**
     * Executable function
     */
    void execute() throws NoteAlreadyExist, NoteNotFoundException, NoteWrongTypeException;
}
