package com.tournament.kotlingraphql.entity.enums

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.STRING)
enum class Region {
    EastAsia, Turkey, Europe
}
