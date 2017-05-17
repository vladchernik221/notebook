package com.notebook.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Page in NoteBook
 * Generation strategy - prototype
 * @author Владислав
 * @version 1.0
 */
@Component
@Scope("prototype")
@Entity
public class ImageNote extends Note{
    /**
     * Constant to generate hasCode
     */
    @Transient
    private final static int HASH_NUMBER = 31;

    /**
     * Image path
     */
    private String URL ="";

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ImageNote imageNote = (ImageNote) o;

        return URL != null ? URL.equals(imageNote.URL) : imageNote.URL == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = HASH_NUMBER * result + (URL != null ? URL.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImageNote{" +
                "URL='" + URL + '\'' +
                '}';
    }
}
