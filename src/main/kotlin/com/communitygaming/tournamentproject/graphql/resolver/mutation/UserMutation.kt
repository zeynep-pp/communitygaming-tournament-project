package com.communitygaming.tournamentproject.graphql.mutation

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.UserRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserMutation (private val userRepository: UserRepository): GraphQLMutationResolver {
    fun newUser(email: String, username: String): User {
        val user = User(email, username)
        user.id = UUID.randomUUID().toString()
        userRepository.save(user)
        return user
    }

    fun deleteUser(id:String): Boolean {
        userRepository.deleteById(id)
        return true
    }

    fun updateUser(id:String, username:String): User {
        val user = userRepository.findById(id)
        user.ifPresent {
            it.username = username
            userRepository.save(it)
        }
        return user.get()
    }
}