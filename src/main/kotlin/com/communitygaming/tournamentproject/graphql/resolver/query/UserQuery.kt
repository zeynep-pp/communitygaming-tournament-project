package com.communitygaming.tournamentproject.graphql.resolver.query


import com.communitygaming.tournamentproject.domain.UserDomain
import com.communitygaming.tournamentproject.graphql.type.Tournament
import com.communitygaming.tournamentproject.graphql.type.User
import com.communitygaming.tournamentproject.service.impl.TournamentServiceImpl
import com.communitygaming.tournamentproject.service.impl.UserServiceImpl
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