package com.communitygaming.tournamentproject.service.impl

import com.communitygaming.tournamentproject.repository.UserRepository
import com.communitygaming.tournamentproject.service.UserService
import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import com.communitygaming.tournamentproject.service.mapper.UserMapper
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserServiceImpl (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val userMapper: UserMapper
) : UserService {

    private val log = LoggerFactory.getLogger(javaClass);


    override fun save(userDto: RegisterInput): RegisterInput {
        log.debug("Request to save User: $userDto")
        var user = userMapper.toEntity(userDto)
        user = userRepository.save(user)
        return userMapper.toDto(user)
    }


    override fun partialUpdate(id: String,userDto: RegisterInput): Optional<RegisterInput> {
        log.debug("Request to partial update User: $userDto")

        return userRepository.findById(id)
            .map {
                userMapper.partialUpdate(it, userDto)
                it
            }
            .map { userRepository.save(it) }
            .map { userMapper.toDto(it) }

    }


    //@Cacheable("users")
    override fun findAll(): MutableList<RegisterInput> {
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

    override fun findOne(id: String): Optional<RegisterInput> {
        log.debug("Request to get User by id: $id")
        return userRepository.findById(id).map(userMapper::toDto)
    }

    override fun delete(id: String) {
        log.debug("Request to delete User by id : $id")
        userRepository.deleteById(id)
    }
}