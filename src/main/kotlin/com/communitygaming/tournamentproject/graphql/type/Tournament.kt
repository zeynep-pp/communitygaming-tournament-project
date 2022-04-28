package com.communitygaming.tournamentproject.graphql.type



data class TournamentType  (
    var id: String? = null,

    var name: String? = null,

    var participants: MutableSet<UserType>? = mutableSetOf(),

    var organizer: UserType? = null,


    )