package com.communitygaming.tournamentproject.security

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component
import java.util.stream.Collectors



@Component
class DomainUserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User NOT Found") }
        return createSpringSecurityUser(user)
    }

    private fun createSpringSecurityUser(user: User): org.springframework.security.core.userdetails.User {
        val authorities: List<SimpleGrantedAuthority> = user.roles!!.stream()
            .map { role -> SimpleGrantedAuthority("ROLE_" + role.name) }.collect(Collectors.toList())

        return User(
            user.username,
            user.password,
            authorities
        )
    }
}
