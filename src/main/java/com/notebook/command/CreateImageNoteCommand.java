package com.notebook.command;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.services.NoteBookService;

/**
 * Command for creating new ImageNote in NoteBook
 * @author Владислав
 * @version 1.0
 */
public class CreateImageNoteCommand implements Command {
    /**
     * title of new TextNote
     */
    private String title;
    /**
     * URL of image in note
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
    public CreateImageNoteCommand(String title, String URL, NoteBookService noteBookService) {
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
