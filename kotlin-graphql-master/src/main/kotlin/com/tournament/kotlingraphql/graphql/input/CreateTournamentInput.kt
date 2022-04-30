package com.tournament.kotlingraphql.graphql.input

import org.springframework.data.annotation.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class CreateTournamentInput(

    var userId: String,

    var tournamentName: String? = null,

    var perTeamNumber: String? = null


)
