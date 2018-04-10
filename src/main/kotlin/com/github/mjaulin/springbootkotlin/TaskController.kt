package com.github.mjaulin.springbootkotlin

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@CrossOrigin
@RequestMapping
class TaskController(val taskRepository: TaskRepository) {

    @GetMapping
    fun findAll() : ResponseEntity<Iterable<Task>> {
        return ResponseEntity.ok(taskRepository.findAll())
    }

    @PostMapping
    fun add(@RequestBody task: Task) : ResponseEntity<Void> {
        val result = taskRepository.save(task)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody task: Task) : Task? {
        task.id = id
        return taskRepository.save(task)
    }

    @DeleteMapping("{id}")
    fun remove(@PathVariable id: String) : ResponseEntity<Void> {
        taskRepository.deleteById(id)
        return ResponseEntity.ok().build()
    }
}