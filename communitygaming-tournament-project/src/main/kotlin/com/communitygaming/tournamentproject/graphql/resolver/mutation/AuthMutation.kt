package com.communitygaming.tournamentproject.graphql.resolver.mutation


import com.communitygaming.tournamentproject.graphql.input.LoginInput
import com.communitygaming.tournamentproject.graphql.resolver.type.JWTToken
import com.communitygaming.tournamentproject.service.AuthService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component


@Component
class AuthMutation(

    private val authService: AuthService
) : GraphQLMutationResolver {


    fun login(loginInput: LoginInput): JWTToken {
        return authService.login(LoginInput())
    }

}
