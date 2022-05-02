package com.communitygaming.tournamentproject.graphql.resolver.query



import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.service.impl.UserServiceImpl
import graphql.kickstart.tools.GraphQLQueryResolver
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