package com.github.mjaulin.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthEndpoint {

    @GetMapping("/health")
    public ResponseEntity<Void> health() {
        return ResponseEntity.noContent().build();
    }

}
