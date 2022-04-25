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

    var tournamentId: String? = null,

    var username: String? = null,
    var password: String? = null,

    @Transient
    var roles: List<Role>? = ArrayList()
) : AbstractAuditingEntity()
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @NotNull
    var username: String? = null,

    @NotNull
    var password: String? = null,

    var isEnabled: Boolean = false,


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )

    @Transient
    var roles: List<Role>? = ArrayList()


) */

