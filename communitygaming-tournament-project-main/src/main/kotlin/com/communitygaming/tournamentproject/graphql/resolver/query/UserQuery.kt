package com.communitygaming.tournamentproject.graphql.resolver.query


import com.communitygaming.tournamentproject.domain.User
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class UserQuery(val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun reviews(tournamentId: String): List<User> {
        val query = Query()
        query.addCriteria(Criteria.where("tournamentId").`is`(tournamentId))
        return mongoOperations.find(query, User::class.java)
    }
}