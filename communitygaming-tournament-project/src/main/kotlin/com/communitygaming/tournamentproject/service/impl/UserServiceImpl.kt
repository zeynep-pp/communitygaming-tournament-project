package com.communitygaming.tournamentproject.service.impl

import com.communitygaming.tournamentproject.graphql.input.CreateUserInput
import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.graphql.input.UpdateUserInput
import com.communitygaming.tournamentproject.repository.UserRepository
import com.communitygaming.tournamentproject.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import java.util.*

@Component
class UserServiceImpl (
    private val userRepository: UserRepository,
    private val mongoOperations: MongoOperations
) : UserService {

    private val log = LoggerFactory.getLogger(javaClass);
    

    override fun save(userDto: CreateUserInput): User {
        if (userRepository.existsOneByUsername(userDto.username!!)) {
            throw RuntimeException(
                String.format("Username %s already exists", userDto.username));
        }
        if (userRepository.existsOneByEmail(userDto.email!!)) {
            throw RuntimeException(
                String.format("Email %s already exists", userDto.email));
        }
        val user = User(UUID.randomUUID().toString(),userDto.username, userDto.password, userDto.email)
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
            it.username = userDto.username
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