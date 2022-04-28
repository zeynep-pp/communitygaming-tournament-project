package com.communitygaming.tournamentproject.graphql.input

import org.springframework.data.annotation.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class CreateTournamentInput(

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var tournamentName: String? = null,

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var userId: String? = null,

)
