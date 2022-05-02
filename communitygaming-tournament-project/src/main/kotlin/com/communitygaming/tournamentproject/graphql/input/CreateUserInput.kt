package com.communitygaming.tournamentproject.graphql.input

import com.mongodb.lang.NonNull
import org.springframework.data.mongodb.core.index.Indexed


data class CreateUserInput(

    var username: String,
    var password: String,

    @Indexed(unique=true)
    @NonNull
    var email:String

)
