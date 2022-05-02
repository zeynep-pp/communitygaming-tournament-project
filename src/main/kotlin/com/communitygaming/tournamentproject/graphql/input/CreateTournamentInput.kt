package com.communitygaming.tournamentproject.graphql.input

import com.communitygaming.tournamentproject.domain.enums.*


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
