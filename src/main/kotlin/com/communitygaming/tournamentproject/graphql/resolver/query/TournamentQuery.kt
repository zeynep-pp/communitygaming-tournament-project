package com.communitygaming.tournamentproject.graphql.resolver.query

import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.TournamentRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class TournamentQuery(val tournamentRepository: TournamentRepository,
                      private val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun tournaments(): List<Tournament> {
        val list = tournamentRepository.findAll()
        for (item in list) {
            item.participants = getUsers(tournamentId = item.id)
        }
        return list
    }

    private fun getUsers(tournamentId: String): List<User> {
        val query = Query()
        query.addCriteria(Criteria.where("tournamentId").`is`(tournamentId))
        return mongoOperations.find(query, User::class.java)
    }
}