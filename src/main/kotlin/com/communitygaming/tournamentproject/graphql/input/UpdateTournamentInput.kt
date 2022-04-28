package com.communitygaming.tournamentproject.graphql.input

import org.springframework.data.annotation.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class UpdateTournamentInput(
    @Id
    @field:NotNull
    var id: String? = null,

    @field:NotNull
    var name: String? = null,

    @field:NotNull
    var userIds: MutableSet<String> = mutableSetOf()
)