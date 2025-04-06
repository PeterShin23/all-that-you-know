package com.pshin23.all_that_you_know.all_that_you_know_backend.repository;

import com.pshin23.all_that_you_know.all_that_you_know_backend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByClusterIdAndParentNoteIsNull(Long clusterId);

    List<Note> findAllByParentNoteId(Long parentNoteId);
}
