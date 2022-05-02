

package com.communitygaming.tournamentproject.repository

import com.communitygaming.tournamentproject.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : MongoRepository<User, String>{
    fun findByUsername(username:String?) : Optional<User>

}