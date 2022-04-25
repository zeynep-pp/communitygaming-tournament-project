package com.tournament.kotlingraphql.entity.enums

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.STRING)
enum class Status {
    Live, New, Past
}
