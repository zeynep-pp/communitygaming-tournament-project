package com.communitygaming.tournamentproject.config


import com.communitygaming.tournamentproject.security.jwt.JWTConfigurer
import com.communitygaming.tournamentproject.security.jwt.JWTProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfiguration(
    private val jwtProvider: JWTProvider
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {

        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .headers().frameOptions().sameOrigin()
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/graphql").permitAll()
            //.antMatchers("/graphql").authenticated()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .apply(securityConfigurerAdapter())
    }

    private fun securityConfigurerAdapter() = JWTConfigurer(jwtProvider)
}
