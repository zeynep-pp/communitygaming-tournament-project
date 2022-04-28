package com.communitygaming.tournamentproject.security

import com.communitygaming.tournamentproject.domain.UserDomain
import com.communitygaming.tournamentproject.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component
import java.util.stream.Collectors



@Component
class DomainUserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val userDomain: UserDomain = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User NOT Found") }
        return createSpringSecurityUser(userDomain)
    }

    private fun createSpringSecurityUser(userDomain: UserDomain): org.springframework.security.core.userdetails.User {
        return org.springframework.security.core.userdetails.User(
            userDomain.username,
            userDomain.password,
            mutableListOf()
        )
    }
}
