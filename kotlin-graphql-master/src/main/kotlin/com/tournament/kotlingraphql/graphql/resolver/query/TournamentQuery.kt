package com.tournament.kotlingraphql.graphql.resolver.query


import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.service.impl.TournamentServiceImpl
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class TournamentQuery(private val tournamentService: TournamentServiceImpl) : GraphQLQueryResolver {
    fun tournaments(userId: String): List<Tournament> {
        return tournamentService.getTournaments(userId)
    }
}