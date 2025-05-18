package com.killswitch.tasky.controller;

import com.killswitch.tasky.model.Task;
import com.killswitch.tasky.model.Note;
import com.killswitch.tasky.service.NoteService;
import com.killswitch.tasky.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@Slf4j
@RestController
public class TaskController {

    private static final String TASK_PATH = "/api/v1/tasks";
    private static final String TASK_PATH_ID = TASK_PATH + "/{taskId}";

    private final TaskService taskService;
    private final NoteService noteService;

    @GetMapping(TASK_PATH)
    public Iterable<Task> getTasks() {
        log.info("Get all tasks");
        return taskService.getAllTasks();
    }

    @GetMapping(TASK_PATH_ID)
    public Task getTaskById(@PathVariable("taskId") Long id) {
        log.info("Get task by id: {}", id);
        return taskService.getTask(id).orElseThrow(NotFoundException::new);
    }


    @GetMapping(TASK_PATH_ID + "/notes")
    public Iterable<Note> getTaskNotes(@PathVariable("taskId") Long id) {
        log.info("Get task notes by id: {}", id);
        return noteService.getNotesByTaskId(id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long id) {
        log.info("Delete task by id: {}", id);

        if (taskService.deleteTask(id)) {
            log.info("Could not delete task with id: {}", id);
            throw new NotFoundException();
        }

        log.info("Deleted task with id: {}", id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(TASK_PATH)
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        log.info("Add task: {}", task);
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path(TASK_PATH_ID).buildAndExpand(createdTask.getId()).toUri()).build();
    }

    @PostMapping(TASK_PATH_ID + "/notes")
    public Note addNoteForTask(@PathVariable("taskId") Long id, @RequestBody Note note) {
        log.info("Add note for task with id: {}, {}", id, note);
        return noteService.addNote(id, note);
    }


}
