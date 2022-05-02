package com.communitygaming.tournamentproject.graphql.resolver.type

import com.fasterxml.jackson.annotation.JsonProperty


/**
 * Object to return as body in JWT Authentication.
 */
data class JWTToken( var idToken: String?= null)
