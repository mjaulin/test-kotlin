package com.github.mjaulin.springbootkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}