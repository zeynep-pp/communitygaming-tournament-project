package com.communitygaming.tournamentproject.security.jwt

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter

class JWTConfigurer(private val jwtProvider: JWTProvider) :
    SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity?) {
        val customFilter = JWTFilter(jwtProvider)
        http!!.addFilterBefore(customFilter, RequestHeaderAuthenticationFilter::class.java)
    }
}
