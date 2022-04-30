package com.tournament.kotlingraphql.graphql.mutation

import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.graphql.input.RegisterInput
import com.tournament.kotlingraphql.service.impl.UserServiceImpl
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.graphql.input.CreateUserInput
import com.tournament.kotlingraphql.graphql.input.UpdateTournamentInput
import com.tournament.kotlingraphql.graphql.input.UpdateUserInput
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import javax.validation.Valid
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