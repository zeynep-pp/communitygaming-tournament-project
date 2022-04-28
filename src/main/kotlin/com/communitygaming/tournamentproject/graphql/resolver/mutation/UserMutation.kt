package com.communitygaming.tournamentproject.graphql.mutation

import com.communitygaming.tournamentproject.domain.UserDomain
import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import com.communitygaming.tournamentproject.graphql.type.User
import com.communitygaming.tournamentproject.service.impl.UserServiceImpl
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Component
class UserMutation (private val userService: UserServiceImpl): GraphQLMutationResolver {
    fun newUser(@Valid @RequestBody user: RegisterInput): User {
        return userService.save(user)
    }
    fun deleteUser(@NotNull id: String): Boolean {
        return userService.delete(id)
    }
}