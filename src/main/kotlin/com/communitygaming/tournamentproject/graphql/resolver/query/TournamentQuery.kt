package com.communitygaming.tournamentproject.graphql.resolver.query


import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.service.impl.TournamentServiceImpl
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class TournamentQuery(private val tournamentService: TournamentServiceImpl) : GraphQLQueryResolver {
    fun tournamentsByUserId(userId: String): List<Tournament> {
        return tournamentService.getTournaments(userId)
    }

    fun tournaments(): MutableList<Tournament> {
        return tournamentService.findAll()
    }

}