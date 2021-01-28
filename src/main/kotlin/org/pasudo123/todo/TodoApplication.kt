package org.pasudo123.todo

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
    fun init() = CommandLineRunner {
        log.info("[custom] commandLineRunner Start!")
    }
}

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}
