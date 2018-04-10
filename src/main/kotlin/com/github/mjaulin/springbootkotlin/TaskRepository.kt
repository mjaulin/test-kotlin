package com.github.mjaulin.springbootkotlin

import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface TaskRepository : CrudRepository<Task, String>