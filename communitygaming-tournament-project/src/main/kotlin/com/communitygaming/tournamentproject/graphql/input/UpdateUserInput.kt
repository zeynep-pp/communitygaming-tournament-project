package com.communitygaming.tournamentproject.graphql.input

import com.mongodb.lang.NonNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed


data class UpdateUserInput(

    @Id
    var id: String = "",
    var username: String,
    var password: String,

    @Indexed(unique=true)
    @NonNull
    var email:String


)
