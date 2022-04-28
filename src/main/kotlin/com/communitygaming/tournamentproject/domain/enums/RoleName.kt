package com.communitygaming.tournamentproject.domain.enums

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.STRING)
enum class RoleName {
    USER, ADMIN, MANAGER
}