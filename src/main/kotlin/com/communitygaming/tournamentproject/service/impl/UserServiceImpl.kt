package com.communitygaming.tournamentproject.service.impl


import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import com.communitygaming.tournamentproject.graphql.type.Tournament
import com.communitygaming.tournamentproject.graphql.type.User
import com.communitygaming.tournamentproject.repository.UserRepository
import com.communitygaming.tournamentproject.service.UserService

import com.communitygaming.tournamentproject.service.mapper.UserMapper
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserServiceImpl (
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val mongoOperations: MongoOperations
) : UserService {

    private val log = LoggerFactory.getLogger(javaClass);

    @CacheEvict(value = ["tournaments"], allEntries = true)
    override fun save(userDto: RegisterInput): User {
        log.debug("Request to save User: $userDto")
        var user = userMapper.toEntity(userDto)
        user = userRepository.save(user)
        return userMapper.toDto(user)
    }


    override fun partialUpdate(id: String,userDto: RegisterInput): Optional<User> {
        log.debug("Request to partial update User: $userDto")

        return userRepository.findById(id)
            .map {
                userMapper.partialUpdate(it, userDto)
                it
            }
            .map { userRepository.save(it) }
            .map { userMapper.toDto(it) }

    }

    override fun findAll(): List<User> {
        log.debug("Request to get all Users")
        simulateSlowService();
        return userRepository.findAll()
            .mapTo(mutableListOf(), userMapper::toDto)
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
        return userRepository.findById(id).map(userMapper::toDto)
    }

    override fun delete(id: String): Boolean  {
        log.debug("Request to delete User by id : $id")
        userRepository.deleteById(id)
        return true
    }

    fun getUsers(): MutableList<User> {
        val list = userMapper.toDto(userRepository.findAll())
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