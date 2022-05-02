package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.CreateUserInput
import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.graphql.input.UpdateUserInput
import java.util.*


interface UserService {

    fun save(userDto: CreateUserInput): User

    fun updateUser(userDto: UpdateUserInput): User

    fun findAll(): List<User>

    fun findOne(id: String): Optional<User>

    fun delete(id: String) : Boolean
}
