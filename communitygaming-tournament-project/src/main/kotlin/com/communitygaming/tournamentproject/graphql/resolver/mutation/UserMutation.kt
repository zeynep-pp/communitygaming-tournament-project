package com.communitygaming.tournamentproject.graphql.resolver.mutation

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.service.impl.UserServiceImpl
import com.communitygaming.tournamentproject.graphql.input.CreateUserInput
import com.communitygaming.tournamentproject.graphql.input.UpdateUserInput
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Component
class UserMutation (private val userService: UserServiceImpl): GraphQLMutationResolver {
    fun newUser(@RequestBody user: CreateUserInput): User {
        return userService.save(user)
    }

    fun updateUser(@RequestBody user: UpdateUserInput ): User {
        return userService.updateUser(user)
    }

    fun deleteUser(@NotNull @Size(min = 1, max = 50) id: String): Boolean {
        return userService.delete(id)
    }
}