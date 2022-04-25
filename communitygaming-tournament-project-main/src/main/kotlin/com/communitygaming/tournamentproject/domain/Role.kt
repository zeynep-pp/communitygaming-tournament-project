package com.communitygaming.tournamentproject.domain

import com.communitygaming.tournamentproject.domain.enums.RoleName
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id


@Document(collection = "role")
data class Role (

    @Id
    var id: String? = null,

    var name: RoleName? = null

)
