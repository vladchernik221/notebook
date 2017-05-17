package com.notebook.serviceImpl;

import com.notebook.config.ContextConfig;
import com.notebook.pojo.ImageNote;
import com.notebook.pojo.Note;
import com.notebook.pojo.TextNote;
import com.notebook.services.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Владислав on 21.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextConfig.class)
public class NoteServiceImplTest {
    @Autowired
    private NoteService noteService;

    @Test
    public void testInjectNoteService() {
        assertNotNull(noteService);
    }

    @Test
    public void testInstanceNoteService(){
        assertThat(noteService, instanceOf(NoteServiceImpl.class));
    }

    @Test
    public void testCreateTextNote() {
        Note note = noteService.createTextNote("mur", "meow");
        assertNotNull(note);
        assertEquals(note.getTitle(), "mur");
        assertEquals(((TextNote)note).getContent(), "meow");
        assertNotNull(note.getCreation());
        assertNotNull(note.getLastEdition());
    }

    @Test
    public void testCreateImageNote() {
        Note note = noteService.createImageNote("mur", "meow");
        assertNotNull(note);
        assertEquals(note.getTitle(), "mur");
        assertEquals(((ImageNote)note).getURL(), "meow");
        assertNotNull(note.getCreation());
        assertNotNull(note.getLastEdition());
    }
}
