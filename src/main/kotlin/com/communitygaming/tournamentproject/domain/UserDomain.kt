package com.communitygaming.tournamentproject.domain

import com.mongodb.lang.NonNull
import org.springframework.data.mongodb.core.mapping.Document
import kotlin.jvm.Transient
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

@Document(collection = "users")
data class UserDomain (
    @Id
    var id: String? = null,

    @Indexed(unique=true)
    @NonNull
    var email:String? = null,
    var username: String? = null,
    var password: String? = null,
) {

    @Transient
    var tournaments: List<TournamentDomain> = ArrayList()
}


