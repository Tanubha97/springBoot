package com.web.app.webapp.service;

import com.web.app.webapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    //retrieveTodos(name) : not a default method of repository

    List<Todo> findByUser(String user);

}
