package com.notebook.serviceImpl;

import com.notebook.config.ApplicationContextProvider;
import com.notebook.config.ContextConfig;
import com.notebook.exceptions.NoteAlreadyExist;
import com.notebook.exceptions.NoteNotFoundException;
import com.notebook.exceptions.NoteWrongTypeException;
import com.notebook.pojo.ImageNote;
import com.notebook.pojo.Note;
import com.notebook.pojo.NoteBook;
import com.notebook.pojo.TextNote;
import com.notebook.repositories.ImageNoteRepository;
import com.notebook.repositories.NoteBookRepository;
import com.notebook.repositories.TextNoteRepository;
import com.notebook.services.NoteBookService;
import com.notebook.services.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Владислав on 20.03.2017.
 *
 * @author Владислав
 * @version $Id: $Id
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextConfig.class)
public class NoteBookServiceTest {

    @Autowired
    NoteBookService noteBookService;

    @Autowired
    NoteBook noteBook;

    @Autowired
    NoteService noteService;

    @Autowired
    NoteBookRepository noteBookRepository;


    /**
     * <p>testInjectNoteBookService.</p>
     */
    @Test
    public void testInjectNoteService() {
        assertNotNull(noteService);
    }

    @Test
    public void testInjectNoteBookService() {
        assertNotNull(noteBookService);
    }

    /**
     * <p>testInjectNoteBook.</p>
     */
    @Test
    public void testInjectNoteBook() {
        assertNotNull(noteBook);
    }

    /**
     * <p>testNoteBookServiceInstanceClass.</p>
     */
    @Test
    public void testNoteBookServiceInstanceClass() {
        assertThat(noteBookService, instanceOf(NoteBookServiceImpl.class));
    }

    @Test
    public void testNoteServiceInstanceClass() {
        assertThat(noteService, instanceOf(NoteServiceImpl.class));
    }

    /**
     * <p>testNoteBookInstanceClass.</p>
     */
    @Test
    public void testNoteBookInstanceClass() {
        assertThat(noteBook, instanceOf(NoteBook.class));
    }

    /**
     * <p>testTextCreateNote.</p>
     */
    @Test
    public void testCreateTextNote() throws NoteAlreadyExist {

        int oldCount = noteBook.getNotes().size();
        noteBookService.pushTextNote("mur", "meow");
        int newCount = noteBook.getNotes().size();


        assertEquals(oldCount + 1, newCount);
        assertNotNull(noteBook.getNotes().get("mur"));
    }

    /**
     * <p>testImageCreateNote.</p>
     */
    @Test
    public void testCreateImageNote() throws NoteAlreadyExist {

        int oldCount = noteBook.getNotes().size();
        noteBookService.pushImageNote("mur-mur-mur", "meow");
        int newCount = noteBook.getNotes().size();


        assertEquals(oldCount + 1, newCount);
        assertNotNull(noteBook.getNotes().get("mur-mur-mur"));
    }

    /**
     * <p>testDeleteNote.</p>
     */
    @Test
    public void testDeleteNote() throws NoteAlreadyExist, NoteNotFoundException {

        noteBookService.pushTextNote("mur-mur", "meow");
        int oldCount = noteBook.getNotes().size();
        noteBookService.deleteNote("mur-mur");
        int newCount = noteBook.getNotes().size();

        assertEquals(oldCount - 1, newCount);
    }

    @Test
    public void testAppendText() throws NoteAlreadyExist, NoteWrongTypeException, NoteNotFoundException {

        noteBookService.pushTextNote("mur1", "meow");
        noteBookService.appendText("mur1", "meow");

        assertNotNull(noteBook.getNotes().get("mur1"));
        assertEquals(((TextNote) noteBook.getNotes().get("mur1")).getContent(), "meow\nmeow");
    }


    @Test(expected = NoteAlreadyExist.class)
    public void testNoteAlreadyExistException() throws NoteAlreadyExist {
        noteBookService.pushTextNote("veh", "meow");
        noteBookService.pushTextNote("veh", "meow");
    }

    @Test(expected = NoteNotFoundException.class)
    public void testNoteNotFoundException() throws NoteNotFoundException {
        noteBookService.deleteNote("vze");
    }

    @Test(expected = NoteNotFoundException.class)
    public void testNoteNotFoundExceptionInChangeURL() throws NoteWrongTypeException, NoteNotFoundException {
        noteBookService.changeImage("123", "nya");
    }

    @Test(expected = NoteWrongTypeException.class)
    public void testNoteWrongTypeExceptionExceptionInChangeURL() throws NoteWrongTypeException,
            NoteAlreadyExist, NoteNotFoundException {
        noteBookService.pushTextNote("pur", "meow");
        noteBookService.changeImage("pur", "nya");
    }

    @Test(expected = NoteNotFoundException.class)
    public void testNoteNotFoundExceptionInAppendText() throws NoteWrongTypeException, NoteNotFoundException {
        noteBookService.appendText("1234", "nya");
    }

    @Test(expected = NoteWrongTypeException.class)
    public void testNoteWrongTypeExceptionExceptionInAppendText() throws NoteWrongTypeException,
            NoteAlreadyExist, NoteNotFoundException {
        noteBookService.pushImageNote("pur22", "meow");
        noteBookService.appendText("pur22", "nya");
    }


    @Test
    public void testJPANoteBook() {
        noteBookRepository.save(noteBook);
        assertEquals(1, noteBookRepository.findAll().size());
        assertEquals(noteBook, noteBookRepository.findAll().get(0));
    }
}
