package com.communitygaming.tournamentproject.graphql.input

import org.springframework.data.mongodb.core.index.Indexed
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class RegisterInput(
    @field:NotNull
    var username: String? = null,

    @field:NotNull
    var password: String? = null,

    @field:Email
    @Indexed
    var email: String? = null
)
