package com.notebook.command;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.exceptions.NoteNotFoundException;
import com.notebook.exceptions.NoteWrongTypeException;
import com.notebook.services.NoteBookService;

/**
 * Append text to TextNote with same title
 * @author Владислав
 * @version 1.0
 */
public class AppendTextCommand implements Command {
    /**
     * title of changing Note
     */
    private String title;
    /**
     * URL of new image
     */
    private String content;
    /**
     * reference of Service which is working with noteBook
     */
    private NoteBookService noteBookService;

    /**
     * Constructor of the command
     * @param title
     * @param content
     * @param noteBookService
     */
    public AppendTextCommand(String title, String content, NoteBookService noteBookService) {
        this.title = title;
        this.content = content;
        this.noteBookService = noteBookService;
    }

    /**
     * see interface Command
     */
    public void execute() throws NoteWrongTypeException, NoteNotFoundException {
        noteBookService.appendText(title, content);
    }
}
