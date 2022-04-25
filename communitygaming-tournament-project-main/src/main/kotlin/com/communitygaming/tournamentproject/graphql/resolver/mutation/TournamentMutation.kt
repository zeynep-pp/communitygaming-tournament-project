package com.communitygaming.tournamentproject.graphql.resolver.mutation


import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.repository.TournamentRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.*

@Component
class TournamentMutation (private val tournamentRepository: TournamentRepository): GraphQLMutationResolver {
    fun newTournament(name: String, perTeamNumber: String): Tournament {
        val tournament = Tournament(name, perTeamNumber)
        tournament.id = UUID.randomUUID().toString()
        tournamentRepository.save(tournament)
        return tournament
    }

    fun deleteTournament(id:String): Boolean {
        tournamentRepository.deleteById(id)
        return true
    }

    fun updateTournament(id:String, perTeamNumber:String): Tournament{
        val tournament = tournamentRepository.findById(id)
        tournament.ifPresent {
            it.perTeamNumber = perTeamNumber
            tournamentRepository.save(it)
        }
        return tournament.get()
    }
}