package com.tournament.kotlingraphql.graphql.input

import com.mongodb.lang.NonNull
import com.tournament.kotlingraphql.entity.Tournament
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class CreateUserInput(

    var name: String,
    var password: String,

    @Indexed(unique=true)
    @NonNull
    var email:String

)
