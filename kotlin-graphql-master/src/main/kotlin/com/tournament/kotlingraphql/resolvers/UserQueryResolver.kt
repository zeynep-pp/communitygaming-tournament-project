package com.tournament.kotlingraphql.resolvers

import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.repository.UserRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class UserQueryResolver(val userRepository: UserRepository,
                        private val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun users(): List<User> {
        val list = userRepository.findAll()
        for (item in list) {
            item.tournaments = getTournaments(userId = item.id)
        }
        return list
    }

    private fun getTournaments(userId: String): List<Tournament> {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        return mongoOperations.find(query, Tournament::class.java)
    }
}