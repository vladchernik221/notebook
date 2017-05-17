package com.notebook.serviceImpl;

import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.exceptions.NoteNotFoundException;
import com.notebook.exceptions.NoteWrongTypeException;
import com.notebook.pojo.ImageNote;
import com.notebook.pojo.Note;
import com.notebook.pojo.NoteBook;
import com.notebook.pojo.TextNote;
import com.notebook.services.NoteBookService;
import com.notebook.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * NoteBookService Implementation
 * @author Владислав
 * @version 1.0
 */
@Service
public class NoteBookServiceImpl implements NoteBookService{

    @Autowired
    private NoteBook noteBook;

    @Autowired
    private NoteService noteService;

    public void pushTextNote(String title, String content) throws NoteAlreadyExist {
        Note note = noteBook.getNotes().get(title);
        if(note != null){
            throw new NoteAlreadyExist("Note with the same title already exist");
        }
        noteBook.getNotes().put(title, noteService.createTextNote(title, content));
    }

    public void pushImageNote(String title, String URL) throws NoteAlreadyExist {
        Note note = noteBook.getNotes().get(title);
        if(note != null){
            throw new NoteAlreadyExist("Note with the same title already exist");
        }
        noteBook.getNotes().put(title, noteService.createImageNote(title, URL));
    }

    public void deleteNote(String title) throws NoteNotFoundException {
        if(!noteBook.getNotes().containsKey(title)){
            throw new NoteNotFoundException("Note with this title does not exist");
        }
        noteBook.getNotes().remove(title);
    }

    public void changeImage(String title, String URL) throws NoteNotFoundException, NoteWrongTypeException {
        Note note = noteBook.getNotes().get(title);
        if(note == null){
            throw new NoteNotFoundException("Note with this title does not exist");
        }
        if(!(note instanceof ImageNote)){
            throw new NoteWrongTypeException("Note has wrong base type");
        }
    }

    public void appendText(String title, String content) throws NoteNotFoundException, NoteWrongTypeException {
        Note note = noteBook.getNotes().get(title);
        if(note == null){
            throw new NoteNotFoundException("Note with this title does not exist");
        }
        if(!(note instanceof TextNote)){
            throw new NoteWrongTypeException("Note has wrong base type");
        }
        ((TextNote)note).setContent(((TextNote)note).getContent()+"\n"+content);
        note.setLastEdition(new Date());
    }
}
