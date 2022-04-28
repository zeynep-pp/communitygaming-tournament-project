package com.communitygaming.tournamentproject.domain

import com.communitygaming.tournamentproject.domain.database.AbstractAuditingEntity
import com.mongodb.lang.NonNull
import org.springframework.data.mongodb.core.mapping.Document
import kotlin.jvm.Transient
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

@Document(collection = "users")
data class User (
    @Id
    var id: String? = null,

    @Indexed(unique=true)
    @NonNull
    var email:String,
    var username: String? = null,
    var password: String? = null,

    @Transient
    var roles: List<Role>? = ArrayList()
) {

    @Transient
    var tournaments: List<Tournament> = ArrayList()
}


