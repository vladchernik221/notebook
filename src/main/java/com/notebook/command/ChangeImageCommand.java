package com.notebook.command;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.services.NoteBookService;

/**
 * Command for changing image in ImageNote
 * @author Владислав
 * @version 1.0
 */
public class ChangeImageCommand implements Command {
    /**
     * title of changing Note
     */
    private String title;
    /**
     * URL of new image
     */
    private String URL;
    /**
     * reference of Service which is working with noteBook
     */
    private NoteBookService noteBookService;

    /**
     * Constructor of the command
     * @param title
     * @param URL
     * @param noteBookService
     */
    public ChangeImageCommand(String title, String URL, NoteBookService noteBookService) {
        this.title = title;
        this.URL = URL;
        this.noteBookService = noteBookService;
    }

    /**
     * see interface Command
     */
    public void execute() throws NoteAlreadyExist {
        noteBookService.pushImageNote(title, URL);
    }
}
