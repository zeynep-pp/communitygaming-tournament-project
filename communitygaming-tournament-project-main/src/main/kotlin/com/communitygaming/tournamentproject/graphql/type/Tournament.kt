package com.communitygaming.tournamentproject.graphql.type



data class Tournament  (
    var id: String? = null,

    var name: String? = null,

    var participants: MutableSet<User>? = mutableSetOf(),

    var organizer: User? = null,


)