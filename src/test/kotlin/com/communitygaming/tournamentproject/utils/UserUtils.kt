package com.communitygaming.tournamentproject.utils

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.UserRepository
import java.lang.UnsupportedOperationException

class UserUtils private constructor() {
    companion object {
        const val DEFAULT_USERNAME = "test"

        @JvmStatic
        fun createEntity(): User {
            return User(
                username = DEFAULT_USERNAME,
                password = "test",
                email = "1234"
            )
        }

        @JvmStatic
        fun initTestUser(userRepository: UserRepository): User {
            userRepository.deleteAll()
            return createEntity()
        }
    }

    init {
        throw UnsupportedOperationException("This is constant class")
    }
}