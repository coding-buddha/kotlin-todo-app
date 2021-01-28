package org.pasudo123.todo.dto

import org.pasudo123.todo.domain.MyTodo

class TodoCreateDto(private var todo: String) {

    fun toEntity(): MyTodo {
        return MyTodo(todo = todo)
    }
}
