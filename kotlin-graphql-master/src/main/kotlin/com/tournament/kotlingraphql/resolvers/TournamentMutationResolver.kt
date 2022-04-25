package com.tournament.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.repository.TournamentRepository
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*

@Component
class TournamentMutationResolver (private val tournamentRepository: TournamentRepository): GraphQLMutationResolver {
    fun newTournament(userId: String, tournamentName: String, perTeamNumber: String
    ): Tournament {
        val tournament = Tournament(userId,tournamentName, perTeamNumber)
        tournamentRepository.save(tournament)
        return tournament
    }
}