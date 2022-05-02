package com.communitygaming.tournamentproject.domain.database

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
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