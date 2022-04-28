package com.communitygaming.tournamentproject.graphql.type

import com.fasterxml.jackson.annotation.JsonProperty


/**
 * Object to return as body in JWT Authentication.
 */
class JWTToken(@get:JsonProperty("id_token") var idToken: String?= null)
