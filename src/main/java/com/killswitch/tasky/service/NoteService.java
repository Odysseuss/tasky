package com.killswitch.tasky.service;

import com.killswitch.tasky.model.entity.Note;

public interface NoteService {

    Iterable<Note> getNotesByTaskId(Long taskId);

    Note addNote(Long taskId, Note note);
}
