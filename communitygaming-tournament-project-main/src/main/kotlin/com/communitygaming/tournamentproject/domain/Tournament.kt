package com.communitygaming.tournamentproject.domain

import com.communitygaming.tournamentproject.domain.database.AbstractAuditingEntity
import com.communitygaming.tournamentproject.domain.enums.BracketType
import com.communitygaming.tournamentproject.domain.enums.Game
import com.communitygaming.tournamentproject.domain.enums.Status
import com.communitygaming.tournamentproject.domain.enums.Token
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id


@Document(collection = "tournament")
data class Tournament (

    @Id
    var id: String = "",

    var tournamentName: String? = null,

    var prizeTarget: String? = null,

    var perTeamNumber: String? = null,

    var bracketType: BracketType = BracketType.SingleElimination,

    var status: Status = Status.New,

    var game: Game = Game.ApexLegends,

    var token: Token = Token.USD,

    var participants: List<User> = ArrayList()


    ): AbstractAuditingEntity(){


}