package com.github.mjaulin.todo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface TaskRepository extends CrudRepository<Task, String> {
}
