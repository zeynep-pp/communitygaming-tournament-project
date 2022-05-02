package com.communitygaming.tournamentproject.graphql.resolver.mutation


import com.communitygaming.tournamentproject.graphql.input.LoginInput
import com.communitygaming.tournamentproject.graphql.resolver.type.JWTToken
import com.communitygaming.tournamentproject.service.AuthService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid


@Component
class AuthMutation(

    private val authService: AuthService
) : GraphQLMutationResolver {


    fun login(@Valid @RequestBody loginInput: LoginInput): JWTToken {
        return authService.login(LoginInput())
    }

}
