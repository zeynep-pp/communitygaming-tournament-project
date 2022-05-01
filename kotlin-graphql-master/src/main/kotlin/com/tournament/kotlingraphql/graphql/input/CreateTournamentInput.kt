package com.tournament.kotlingraphql.graphql.input

import com.tournament.kotlingraphql.entity.enums.*
import org.springframework.data.annotation.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class CreateTournamentInput(

    var userId: String,

    var tournamentName: String,

    var perTeamNumber: String? = null,

    var bracketType: BracketType? = null,

    var status: Status? = null,

    var region: Region? = null,

    var game: Game? = null,

    var token: Token? = null


)
