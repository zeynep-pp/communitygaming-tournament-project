package com.communitygaming.tournamentproject.service.impl

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.UserRepository
import com.communitygaming.tournamentproject.service.UserService
import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import com.communitygaming.tournamentproject.graphql.type.UserType
import com.communitygaming.tournamentproject.service.mapper.UserMapper
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*
import javax.transaction.Transactional

@Component
class UserServiceImpl (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val userMapper: UserMapper
) : UserService {

    private val log = LoggerFactory.getLogger(javaClass);

    @CacheEvict(value = ["tournaments"], allEntries = true)
    override fun save(userDto: UserType): UserType {
        log.debug("Request to save User: $userDto")
        var user = userMapper.toEntity(userDto)
        user = userRepository.save(user)
        return userMapper.toDto(user)
    }


    override fun partialUpdate(id: String,userDto: UserType): Optional<UserType> {
        log.debug("Request to partial update User: $userDto")

        return userRepository.findById(id)
            .map {
                userMapper.partialUpdate(it, userDto)
                it
            }
            .map { userRepository.save(it) }
            .map { userMapper.toDto(it) }

    }

    override fun findAll(): MutableList<UserType> {
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

    override fun findOne(id: String): Optional<UserType> {
        log.debug("Request to get User by id: $id")
        return userRepository.findById(id).map(userMapper::toDto)
    }

    override fun delete(id: String) {
        log.debug("Request to delete User by id : $id")
        userRepository.deleteById(id)
    }

    fun getUser(id: String): UserType {
        val user = getUserByRepository(id)
        return userMapper.toDto(user);
    }

    fun getUserByRepository(id: String): User {
        return userRepository.findById(id).orElseThrow { RuntimeException(String.format("User %s not found", id))  }
    }

}