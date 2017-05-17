package com.notebook.pojo;

import com.notebook.services.NoteService;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Use to create and keep notes
 * Generation strategy - singleton
 * @author Владислав
 * @version 1.0
 */
@Component
@Entity
public class NoteBook {
    @Id
    @GeneratedValue
    private int id;
    /**
     * Constant to generate hasCode
     */
    @Transient
    private final static int HASH_NUMBER = 31;

    /**
     * Collection of notes
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Map<String, Note> notes = new HashMap();
    /**
     * Name of the com.notebook
     */
    @Column(unique = true)
    private String name = "";

    @Autowired
    @Transient
    private NoteService noteService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Note> getNotes() {
        return notes;
    }

    public void setNotes(Map<String, Note> notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pushNote(Note note){
        notes.put(note.getTitle(), note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoteBook noteBook = (NoteBook) o;

        return notes.equals(noteBook.notes) && name.equals(noteBook.name);
    }

    @Override
    public int hashCode() {
        int result = notes.hashCode();
        result = HASH_NUMBER * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                ", name='" + name + '\'' +
                "CountNotes=" + notes.size() +
                '}';
    }
}
