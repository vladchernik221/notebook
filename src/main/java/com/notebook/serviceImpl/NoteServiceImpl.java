package com.notebook.serviceImpl;

import com.notebook.config.ApplicationContextProvider;
import com.notebook.pojo.ImageNote;
import com.notebook.pojo.Note;
import com.notebook.pojo.TextNote;
import com.notebook.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Владислав on 21.03.2017.
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    public Note createTextNote(String title, String content) {
        TextNote note = (TextNote) applicationContextProvider.getApplicationContext().getBean("textNote");
        Date date = new Date();
        note.setTitle(title);
        note.setCreation(date);
        note.setLastEdition(date);
        note.setContent(content);
        return note;
    }

    public Note createImageNote(String title, String URL) {
        ImageNote note = (ImageNote) applicationContextProvider.getApplicationContext().getBean("imageNote");
        Date date = new Date();
        note.setTitle(title);
        note.setCreation(date);
        note.setLastEdition(date);
        note.setURL(URL);
        return note;
    }
}