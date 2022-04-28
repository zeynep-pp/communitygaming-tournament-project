package com.communitygaming.tournamentproject.graphql.resolver.mutation


import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.graphql.type.Tournament
import com.communitygaming.tournamentproject.service.impl.TournamentServiceImpl
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Component
@Validated
class TournamentMutation (
    private val tournamentService: TournamentServiceImpl
) : GraphQLMutationResolver {

    fun newTournament(@Valid @RequestBody tournament: CreateTournamentInput): Tournament {
        return tournamentService.save(tournament)
    }

    /*
    fun updateTournament(@NotNullid: String, @Valid @RequestBody tournament: UpdateTournamentInput
    ): TournamentInput {
        return tournamentService.partialUpdate(tournament)
    }*/

    fun deleteTournament(@NotNull  id: String): Boolean {
        return tournamentService.delete(id)
    }

}