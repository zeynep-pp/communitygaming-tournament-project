package com.communitygaming.tournamentproject.graphql.type



data class User (
    var id: String,

    var username: String? = null,

    var email: String? = null,

    var password: String? = null,

    var tournaments: List<Tournament> = ArrayList()

)