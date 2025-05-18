package com.killswitch.tasky.repository;

import com.killswitch.tasky.model.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByTaskId(Long taskId);
}
