package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import com.communitygaming.tournamentproject.graphql.type.User
import java.util.*


interface UserService {

    fun save(userDto: RegisterInput): User

    fun partialUpdate(id: String,userDto:  RegisterInput): Optional<User>

    fun findAll(): List<User>

    fun findOne(id: String): Optional<User>

    fun delete(id: String) : Boolean
}
