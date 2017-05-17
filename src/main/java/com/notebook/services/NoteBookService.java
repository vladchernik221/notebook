package com.notebook.services;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.exceptions.NoteNotFoundException;
import com.notebook.exceptions.NoteWrongTypeException;
import com.notebook.pojo.Note;

/**
 * NoteBook business logic
 * @author Владислав
 * @version 1.0
 */
public interface NoteBookService {

    /**
     * Add Note to NoteBook
     * @param title - title of adding note
     * @param content - content of adding note
     */
    void pushTextNote(String title, String content) throws NoteAlreadyExist;

    /**
     * Add Note to NoteBook
     * @param title - title of adding note
     * @param URL - URL of image in note
     */
    void pushImageNote(String title, String URL) throws NoteAlreadyExist;

    /**
     * Delete note by title
     * @param title - title of deleting note
     */
    void deleteNote(String title) throws NoteNotFoundException;

    /**
     * Changing image in note
     * @param title - title of the changing note
     * @param URL - new image's URL
     */
    void changeImage(String title, String URL) throws NoteNotFoundException, NoteWrongTypeException;

    /**
     * Append text to TextNode
     * @param title - title of the right note
     * @param content - adding text
     */
    void appendText(String title, String content) throws NoteNotFoundException, NoteWrongTypeException;
}
