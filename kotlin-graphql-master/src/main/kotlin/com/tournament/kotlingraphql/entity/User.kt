

package com.tournament.kotlingraphql.entity;

import com.mongodb.lang.NonNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
        var name: String,
        var password: String,

        @Indexed(unique=true)
        @NonNull
        var email:String
) {
    @Id
    var id: String = ""

    @Transient
    var tournaments: List<Tournament> = ArrayList()
}