package com.communitygaming.tournamentproject.graphql.input

import org.springframework.data.annotation.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class CreateTournamentInput(

    @Id
    @field:NotNull
    var id: String? = null,

    @field:NotNull
    var tournamentName: String? = null,

    @field:NotNull
    var userOwnerId: String? = null,

)
