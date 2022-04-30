package com.tournament.kotlingraphql.graphql.input

import org.springframework.data.mongodb.core.index.Indexed
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class RegisterInput(
    @field:NotNull
    @field:Size(min = 1, max = 50)
    var username: String,

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var password: String,

    @field:Email
    @field:Size(min = 1, max = 50)
    @Indexed
    var email: String
)
