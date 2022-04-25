package com.communitygaming.tournamentproject.service


import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import java.util.*


interface UserService {

    fun save(userDto: RegisterInput): RegisterInput

    fun partialUpdate(id: String,userDto: RegisterInput): Optional<RegisterInput>

    fun findAll(): MutableList<RegisterInput>

    fun findOne(id: String): Optional<RegisterInput>

    fun delete(id: String)
}
