package com.communitygaming.tournamentproject.graphql.input


import org.springframework.data.annotation.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class UpdateTournamentInput(

    @Id
    var id: String = "",
    var userId:  String,

    var tournamentName: String? = null,

    var perTeamNumber: String? = null
)
