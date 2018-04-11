package com.github.mjaulin.springbootkotlin

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping
class HealthController {

    @GetMapping("/health")
    fun health(): ResponseEntity<Void> {
        return ResponseEntity.noContent().build()
    }
}