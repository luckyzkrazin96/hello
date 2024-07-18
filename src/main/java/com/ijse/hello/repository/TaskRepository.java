package com.ijse.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hello.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    //You can write Custom Queries
}
