package org.pasudo123.todo

import org.pasudo123.todo.domain.MyTodo
import org.pasudo123.todo.repository.TodoRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TodoApplication {

    private val log = LoggerFactory.getLogger(TodoApplication::class.java)

    @Bean
    fun init(todoRepository: TodoRepository) = CommandLineRunner {
        log.info("[custom] commandLineRunner Start!")
        todoRepository.save(MyTodo(todo = "study java"))
        todoRepository.save(MyTodo(todo = "study kotlin"))
        todoRepository.save(MyTodo(todo = "study c++"))
        todoRepository.save(MyTodo(todo = "study javascript"))
        todoRepository.save(MyTodo(todo = "study golang"))
    }
}

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}
