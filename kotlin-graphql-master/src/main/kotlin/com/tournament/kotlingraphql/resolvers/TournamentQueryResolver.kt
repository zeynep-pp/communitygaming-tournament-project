package com.tournament.kotlingraphql.resolvers

import com.tournament.kotlingraphql.entity.Tournament
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class TournamentQueryResolver(val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun tournaments(userId: String): List<Tournament> {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        return mongoOperations.find(query, Tournament::class.java)
    }
}