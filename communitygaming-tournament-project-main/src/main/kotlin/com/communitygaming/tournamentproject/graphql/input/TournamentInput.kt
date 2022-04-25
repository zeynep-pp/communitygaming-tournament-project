package com.communitygaming.tournamentproject.graphql.input

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class TournamentInput(

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var tournamentName: String? = null,

    @field:NotNull
    var userIds: MutableSet<String> = mutableSetOf()



)