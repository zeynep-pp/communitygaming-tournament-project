package com.communitygaming.tournamentproject.security

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component


@Component
class DomainUserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User NOT Found") }
        return createSpringSecurityUser(user)
    }

    private fun createSpringSecurityUser(user: User): org.springframework.security.core.userdetails.User {
        return org.springframework.security.core.userdetails.User(
            user.username,
            user.password,
            mutableListOf()
        )
    }
}
