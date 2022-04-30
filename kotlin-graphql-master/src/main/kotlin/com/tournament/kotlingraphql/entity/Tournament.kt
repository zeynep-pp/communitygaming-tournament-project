
package com.tournament.kotlingraphql.entity;

import com.tournament.kotlingraphql.entity.database.AbstractAuditingEntity
import com.tournament.kotlingraphql.entity.enums.BracketType
import com.tournament.kotlingraphql.entity.enums.Game
import com.tournament.kotlingraphql.entity.enums.Status
import com.tournament.kotlingraphql.entity.enums.Token
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id


@Document(collection = "tournament")
data class Tournament (

        @Id
        var id: String = "",

        var userId: String,

        var tournamentName: String? = null,

        var perTeamNumber: String? = null

        /*
        var bracketType: BracketType = BracketType.SingleElimination,

        var status: Status = Status.New,

        var game: Game = Game.ApexLegends,

        var token: Token = Token.USD*/


)