package org.pasudo123.todo.controller

import org.pasudo123.todo.domain.MyTodo
import org.pasudo123.todo.service.TodoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(private val todoService: TodoService) {

    @GetMapping("/")
    fun index(): String {
        return "Hello Todo Application"
    }

    @GetMapping("todos")
    fun findAll(): ArrayList<MyTodo> {
        return todoService.findAll()
    }
}