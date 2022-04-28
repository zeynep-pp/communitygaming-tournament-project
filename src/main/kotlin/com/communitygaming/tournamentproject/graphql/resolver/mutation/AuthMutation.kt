package com.communitygaming.tournamentproject.graphql.resolver.mutation

import com.communitygaming.tournamentproject.graphql.input.LoginInput
import com.communitygaming.tournamentproject.graphql.type.JWTToken
import com.communitygaming.tournamentproject.security.jwt.JWTFilter
import com.communitygaming.tournamentproject.security.jwt.JWTProvider
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@Component
@Validated
class AuthMutation(
    private val tokenProvider: JWTProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
) : GraphQLMutationResolver {
    
    fun authorize(@Valid @RequestBody loginInput: LoginInput): ResponseEntity<JWTToken> {

        val authenticationToken = UsernamePasswordAuthenticationToken(loginInput.username, loginInput.password)

        val authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken)
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = tokenProvider.createToken(authentication, loginInput.isRememberMe ?: false)
        val httpHeaders = HttpHeaders()
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer $jwt")
        return ResponseEntity(JWTToken(jwt), httpHeaders, HttpStatus.OK)
    }

}
