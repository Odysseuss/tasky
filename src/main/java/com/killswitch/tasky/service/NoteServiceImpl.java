package com.killswitch.tasky.service;

import com.killswitch.tasky.model.entity.Note;
import com.killswitch.tasky.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Iterable<Note> getNotesByTaskId(Long id) {
        return noteRepository.findByTaskId(id);
    }

    @Override
    public Note addNote(Long taskId, Note note) {
        note.setTaskId(taskId);
        note.setCreatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }
}
