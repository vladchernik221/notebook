package com.notebook.services;

import com.notebook.pojo.Note;

import java.util.Date;

/**
 * Note business logic
 * @author Владислав
 * @version 1.0
 */
public interface NoteService {
    /**
     * Create new TextNote
     * @param title - title of new Note
     * @param content - content of new Note
     * @return New Note
     */
    Note createTextNote(String title, String content);

    /**
     * Create new TextNote
     * @param title - title of new Note
     * @param URL - URL of image in note
     * @return New Note
     */
    Note createImageNote(String title, String URL);
}
