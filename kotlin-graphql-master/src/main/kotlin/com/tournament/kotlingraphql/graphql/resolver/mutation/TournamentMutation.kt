package com.tournament.kotlingraphql.graphql.resolver.mutation


import com.tournament.kotlingraphql.graphql.input.CreateTournamentInput
import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.service.impl.TournamentServiceImpl
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.tournament.kotlingraphql.graphql.input.UpdateTournamentInput
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

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