package com.tournament.kotlingraphql.graphql.resolver.query



import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.service.impl.TournamentServiceImpl
import com.tournament.kotlingraphql.service.impl.UserServiceImpl
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userService: UserServiceImpl) : GraphQLQueryResolver {

    fun users(): MutableList<User> {
        return userService.getUsers()
    }

    private fun getTournaments(userId: String): List<Tournament> {
        return userService.getTournaments(userId)
    }

}