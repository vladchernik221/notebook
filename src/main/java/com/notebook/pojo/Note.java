package com.notebook.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Page in NoteBook
 * Generation strategy - prototype
 * @author Владислав
 * @version 1.0
 */
@Component
@Scope("prototype")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Note {
    @Id
    @GeneratedValue
    private int id;
    /**
     * Constant to generate hasCode
     */
    @Transient
    private final static int HASH_NUMBER = 31;
    /**
     * Name of the note
     */
    private String title = "";
    /**
     * Date of note creation
     */
    private Date creation = new Date();
    /**
     * Date of note last edition
     */
    private Date lastEdition = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getLastEdition() {
        return lastEdition;
    }

    public void setLastEdition(Date lastEdition) {
        this.lastEdition = lastEdition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return title.equals(note.title) && creation.equals(note.creation) && lastEdition.equals(note.lastEdition);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = HASH_NUMBER * result + creation.hashCode();
        result = HASH_NUMBER * result + lastEdition.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", creation=" + creation.toString() +
                ", lastEdition=" + lastEdition.toString() +
                '}';
    }
}
