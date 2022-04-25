package com.tournament.kotlingraphql.resolvers

import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.repository.UserRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserMutationResolver (private val userRepository: UserRepository): GraphQLMutationResolver {
    fun newUser(name: String, password: String, email: String ): User {
        val user = User(name, password , email )
        user.id = UUID.randomUUID().toString()
        userRepository.save(user)
        return user
    }

    fun deleteUser(id:String): Boolean {
        userRepository.deleteById(id)
        return true
    }

    fun updateUser(id:String, name: String, password: String, email: String): User {
        val user = userRepository.findById(id)
        user.ifPresent {
            it.name=name
            it.password = password
            it.email = email
            userRepository.save(it)
        }
        return user.get()
    }
}