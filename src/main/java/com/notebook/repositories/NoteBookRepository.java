package com.notebook.repositories;

import com.notebook.pojo.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Владислав on 28.02.2017.
 */
@Repository
public interface NoteBookRepository extends JpaRepository<NoteBook, Long> {
}
