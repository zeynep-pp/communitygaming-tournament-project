package com.communitygaming.tournamentproject.graphql.resolver


import com.communitygaming.tournamentproject.graphql.type.Tournament
import com.communitygaming.tournamentproject.graphql.type.User
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component

@Component
class TournamentResolver : GraphQLResolver<Tournament> {

    fun participants(tournament: Tournament): MutableSet<User>? {
        return tournament.participants
    }
}