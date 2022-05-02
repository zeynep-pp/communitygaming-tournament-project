package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.LoginInput
import com.communitygaming.tournamentproject.graphql.resolver.type.JWTToken
import com.communitygaming.tournamentproject.security.jwt.JWTProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class AuthService (
    private val tokenProvider: JWTProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
)  {

    fun login(loginInput: LoginInput): JWTToken {

        val authenticationToken = UsernamePasswordAuthenticationToken(loginInput.username, loginInput.password)

        val authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken)
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = tokenProvider.createToken(authentication, loginInput.isRememberMe ?: false)
        return JWTToken(jwt)
    }
}