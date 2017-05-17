package com.notebook.command;

import com.notebook.exceptions.NoteNotFoundException;
import com.notebook.services.NoteBookService;

/**
 * Command for deleting note
 * @author Владислав
 * @version 1.0
 */
public class DeleteNoteCommand implements Command {
    /**
     * Title of deleting note
     */
    String title;
    /**
     * reference of Service which is working with noteBook
     */
    NoteBookService noteBookService;

    /**
     * Constructor of the command
     * @param title
     * @param noteBookService
     */
    public DeleteNoteCommand(String title, NoteBookService noteBookService) {
        this.title = title;
        this.noteBookService = noteBookService;
    }

    /**
     * see to interface Command
     */
    public void execute() throws NoteNotFoundException {
        noteBookService.deleteNote(title);
    }
}
