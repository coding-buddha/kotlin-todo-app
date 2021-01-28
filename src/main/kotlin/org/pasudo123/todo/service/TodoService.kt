package org.pasudo123.todo.service

import org.pasudo123.todo.domain.MyTodo
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class TodoService {

    private val currentTodos = ArrayList<MyTodo>()

    @PostConstruct
    fun init() {
        for(i in 0L..10L) {
            currentTodos.add(MyTodo(id = i, todo = "$i my todo"))
        }
    }

    fun findAll(): ArrayList<MyTodo> {
        return currentTodos
    }
}