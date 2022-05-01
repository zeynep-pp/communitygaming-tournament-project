package com.tournament.kotlingraphql.entity.database

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

/**
 * Basic auditing entity
 */
abstract class AbstractAuditingEntity (


    @CreatedDate
    var createdAt: String = Date.from(Instant.now()).toString(),
    @LastModifiedDate
    var updatedAt: String = Date.from(Instant.now()).toString()
)