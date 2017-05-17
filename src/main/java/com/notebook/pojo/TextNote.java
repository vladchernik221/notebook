package com.notebook.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
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
public class TextNote extends Note{
    @Transient
    private final static int HASH_NUMBER = 31;

    /**
     * Note Text
     */
    private String content = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TextNote textNote = (TextNote) o;

        return content != null ? content.equals(textNote.content) : textNote.content == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = HASH_NUMBER * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TextNote{" +
                "content='" + content + '\'' +
                '}';
    }
}
