package com.tournament.kotlingraphql.service

import com.tournament.kotlingraphql.graphql.input.CreateUserInput
import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.graphql.input.UpdateUserInput
import java.util.*


interface UserService {

    fun save(userDto: CreateUserInput): User

    fun updateUser(userDto: UpdateUserInput): User

    fun findAll(): List<User>

    fun findOne(id: String): Optional<User>

    fun delete(id: String) : Boolean
}
