package com.tournament.kotlingraphql.service.impl

import com.tournament.kotlingraphql.graphql.input.CreateUserInput
import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.graphql.input.UpdateUserInput
import com.tournament.kotlingraphql.repository.UserRepository
import com.tournament.kotlingraphql.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserServiceImpl (
    private val userRepository: UserRepository,
    private val mongoOperations: MongoOperations
) : UserService {

    private val log = LoggerFactory.getLogger(javaClass);
    

    override fun save(userDto: CreateUserInput): User {
        val user = User(userDto.name, userDto.password, userDto.email )
        user.id = UUID.randomUUID().toString()
        return userRepository.save(user)
    }

    fun deleteUser(id:String): Boolean {
        userRepository.deleteById(id)
        return true
    }

    override fun updateUser(userDto: UpdateUserInput): User {
        log.debug("Request to  update User: $userDto")
        val user = userRepository.findById(userDto.id)
        user.ifPresent {
            it.name = userDto.name
            it.email= userDto.email
            it.password=userDto.password
            userRepository.save(it)
        }
        return user.get()
    }

    override fun findAll(): List<User> {
        log.debug("Request to get all Users")
        simulateSlowService();
        return userRepository.findAll()
    }

    private fun simulateSlowService() {
        try {
            val time = 3000L
            Thread.sleep(time)
        } catch (e: InterruptedException) {
            throw IllegalStateException(e)
        }
    }

    override fun findOne(id: String): Optional<User> {
        log.debug("Request to get User by id: $id")
        return userRepository.findById(id)
    }

    override fun delete(id: String): Boolean  {
        log.debug("Request to delete User by id : $id")
        userRepository.deleteById(id)
        return true
    }


    fun getUsers(): MutableList<User> {
        val list = userRepository.findAll()
        for (item in list) {
            item.tournaments = getTournaments(userId = item.id)
        }
        return list
    }

    fun getTournaments(userId: String): List<Tournament> {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        return mongoOperations.find(query, Tournament::class.java)
    }


}