package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.type.UserType
import java.util.*


interface UserService {

    fun save(userDto: UserType): UserType

    fun partialUpdate(id: String,userDto: UserType): Optional<UserType>

    fun findAll(): MutableList<UserType>

    fun findOne(id: String): Optional<UserType>

    fun delete(id: String)
}
