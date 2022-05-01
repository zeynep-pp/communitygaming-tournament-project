

package com.tournament.kotlingraphql.entity;

import com.mongodb.lang.NonNull
import com.tournament.kotlingraphql.entity.database.AbstractAuditingEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@Document(collection = "user")
class User(
    @Id
    var id: String = "",
    var name: String,
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