package org.pasudo123.todo.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MyTodo(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var todo: String
)
