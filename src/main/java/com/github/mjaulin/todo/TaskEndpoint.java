package com.github.mjaulin.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskEndpoint {

    private final TaskRepository taskRepository;

    public TaskEndpoint(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Task>> findAll() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody Task task) {
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@PathVariable String id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        taskRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
