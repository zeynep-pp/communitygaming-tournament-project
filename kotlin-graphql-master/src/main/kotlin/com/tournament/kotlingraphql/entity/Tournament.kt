
package com.tournament.kotlingraphql.entity;

import com.tournament.kotlingraphql.entity.database.AbstractAuditingEntity
import com.tournament.kotlingraphql.entity.enums.*
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id


@Document(collection = "tournament")
data class Tournament (

        @Id
        var id: String = "",

        var userId: String,

        var tournamentName: String? = null,

        var perTeamNumber: String? = null,

        var bracketType: BracketType ? = null,

        var status: Status? = null,

        var region: Region? = null,

        var game: Game? = null,

        var token: Token? = null


)