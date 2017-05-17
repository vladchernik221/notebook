package com.notebook.command;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.services.NoteBookService;

/**
 * Command for creating new TextNode in NoteBook
 * @author Владислав
 * @version 1.0
 */
public class CreateTextNoteCommand implements Command {
    /**
     * title of new TextNote
     */
    private String title;
    /**
     * content of new Note
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
    public CreateTextNoteCommand(String title, String content, NoteBookService noteBookService) {
        this.title = title;
        this.content = content;
        this.noteBookService = noteBookService;
    }

    /**
     * see to interface Command
     */
    public void execute() throws NoteAlreadyExist {
        noteBookService.pushTextNote(title, content);
    }
}
