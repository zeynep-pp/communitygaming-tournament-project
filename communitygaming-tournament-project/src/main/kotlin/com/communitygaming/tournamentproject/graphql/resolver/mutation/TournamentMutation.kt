package com.communitygaming.tournamentproject.graphql.resolver.mutation


import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.service.impl.TournamentServiceImpl
import com.communitygaming.tournamentproject.graphql.input.UpdateTournamentInput
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.constraints.NotNull

@Component
class TournamentMutation (
    private val tournamentService: TournamentServiceImpl
) : GraphQLMutationResolver {

    fun newTournament(@RequestBody tournament: CreateTournamentInput): Tournament {
        return tournamentService.save(tournament)
    }


    fun updateTournament(@RequestBody tournament: UpdateTournamentInput
    ): Tournament {
        return tournamentService.partialUpdate(tournament)
    }

    fun deleteTournament(@NotNull id: String): Boolean {
        return tournamentService.delete(id)
    }

}