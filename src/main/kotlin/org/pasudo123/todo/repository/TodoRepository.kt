package org.pasudo123.todo.repository

import org.pasudo123.todo.domain.MyTodo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TodoRepository: JpaRepository<MyTodo, Long> {
    override fun findById(id: Long): Optional<MyTodo>
    override fun findAll(): List<MyTodo>
}