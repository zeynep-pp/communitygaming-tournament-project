

package com.tournament.kotlingraphql.repository

import com.tournament.kotlingraphql.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>