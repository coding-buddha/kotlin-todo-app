package org.pasudo123.todo.service

import org.pasudo123.todo.domain.MyTodo
import org.pasudo123.todo.dto.TodoCreateDto
import org.pasudo123.todo.dto.TodoUpdateDto
import org.pasudo123.todo.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import javax.persistence.EntityNotFoundException

@Service
@Transactional
class TodoService(private val todoRepository: TodoRepository) {

    private val currentTodos = ArrayList<MyTodo>()

    @PostConstruct
    fun init() {
        for(i in 0L..10L) {
            currentTodos.add(MyTodo(id = i, todo = "$i my todo"))
        }
    }

    fun findAllByMemory(): ArrayList<MyTodo> {
        return currentTodos
    }

    fun createTodo(createDto: TodoCreateDto): MyTodo {
        return todoRepository.save(createDto.toEntity())
    }

    @Transactional(readOnly = true)
    fun findAll(): List<MyTodo> {
        return todoRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): MyTodo {
        return todoRepository.findById(id)
                .orElse(null) ?: throw EntityNotFoundException("this todo does not exist")
    }

    fun update(id: Long, updateDto: TodoUpdateDto): MyTodo {
        val foundTodo = this.findById(id)
        // 더티체킹 알아서 잘되고 있음
        foundTodo.todo = updateDto.todo
        return foundTodo
    }

    fun deleteById(id: Long): Map<String, Any> {
        try {
            this.findById(id)
        } catch (e: EntityNotFoundException) {
            return mapOf(Pair("result", "does not exist, delete failed"))
        }

        todoRepository.deleteById(id)
        return mapOf(Pair("result", "delete success"))
    }
}