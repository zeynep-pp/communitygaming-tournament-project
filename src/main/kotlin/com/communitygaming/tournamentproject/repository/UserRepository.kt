package com.communitygaming.tournamentproject.repository

import com.communitygaming.tournamentproject.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*


@Repository
interface UserRepository : MongoRepository<User, String> {

    fun findByUsername(username:String?) : Optional<User>
}