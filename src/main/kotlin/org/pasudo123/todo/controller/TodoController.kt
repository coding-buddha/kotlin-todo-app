package org.pasudo123.todo.controller

import org.pasudo123.todo.domain.MyTodo
import org.pasudo123.todo.dto.TodoCreateDto
import org.pasudo123.todo.dto.TodoUpdateDto
import org.pasudo123.todo.service.TodoService
import org.springframework.web.bind.annotation.*

@RestController
class TodoController(private val todoService: TodoService) {

    @GetMapping("/")
    fun index(): String {
        return "Hello Todo Application"
    }

    @GetMapping("todos-memory")
    fun findAllMyMemory(): ArrayList<MyTodo> {
        return todoService.findAllByMemory()
    }

    @PostMapping("todos")
    fun createTodo(createDto: TodoCreateDto): MyTodo {
        return todoService.createTodo(createDto)
    }

    @GetMapping("todos")
    fun findAll(): List<MyTodo> {
        return todoService.findAll()
    }

    @GetMapping("todos/{id}")
    fun findAll(@PathVariable("id") id: Long): MyTodo {
        return todoService.findById(id)
    }

    @PutMapping("todos/{id}")
    fun update(@PathVariable("id") id: Long, updateDto: TodoUpdateDto): MyTodo {
        return todoService.update(id, updateDto)
    }

    @DeleteMapping("todos/{id}")
    fun delete(@PathVariable("id") id: Long): Map<String, Any> {
        return todoService.deleteById(id)
    }
}