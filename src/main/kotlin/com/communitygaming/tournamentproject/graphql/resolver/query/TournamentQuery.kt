package com.communitygaming.tournamentproject.graphql.resolver.query


import com.communitygaming.tournamentproject.graphql.type.Tournament
import com.communitygaming.tournamentproject.service.impl.TournamentServiceImpl
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class TournamentQuery(private val tournamentService: TournamentServiceImpl) : GraphQLQueryResolver {
    fun tournaments(userId: String): List<Tournament> {
        return tournamentService.getTournaments(userId)
    }
}