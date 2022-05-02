package com.communitygaming.tournamentproject.security.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("security.token")
data class TokenProperties (
    var tokenValidityInSeconds: Long = 1800L,
    var base64Secret: String? = null

)