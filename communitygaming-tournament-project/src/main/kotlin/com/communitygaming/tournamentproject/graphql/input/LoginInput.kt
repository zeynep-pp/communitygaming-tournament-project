package com.communitygaming.tournamentproject.graphql.input

import org.springframework.data.annotation.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class LoginInput(

    @field:NotNull
    var username: String? = null,

    @field:NotNull
    var password: String? = null,

    var isRememberMe: Boolean? = null

)


