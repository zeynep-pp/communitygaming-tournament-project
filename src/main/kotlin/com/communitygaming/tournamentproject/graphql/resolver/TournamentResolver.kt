package com.communitygaming.tournamentproject.graphql.resolver


import com.communitygaming.tournamentproject.graphql.type.TournamentType
import com.communitygaming.tournamentproject.graphql.type.UserType
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class TournamentResolver : GraphQLResolver<TournamentType> {

    fun participants(tournament: TournamentType): MutableSet<UserType>? {
        return tournament.participants
    }
}