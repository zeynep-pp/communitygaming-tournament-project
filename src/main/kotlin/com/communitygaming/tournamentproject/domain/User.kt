

package com.communitygaming.tournamentproject.domain;

import com.mongodb.lang.NonNull
import com.communitygaming.tournamentproject.domain.database.AbstractAuditingEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

@Document(collection = "user")
class User(
    @Id
    var id: String = "",
    var username: String,
    var password: String,

    @Indexed(unique=true)
    @NonNull
    var email:String,

    createdAt: String = Date.from(Instant.now()).toString(),
    updatedAt: String = Date.from(Instant.now()).toString()
): AbstractAuditingEntity(createdAt, updatedAt){
    @Transient
    var tournaments: List<Tournament> = ArrayList()
}