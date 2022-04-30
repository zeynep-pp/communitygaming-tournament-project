package com.tournament.kotlingraphql.service

import com.tournament.kotlingraphql.graphql.input.CreateTournamentInput
import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.graphql.input.UpdateTournamentInput
import java.util.*


interface TournamentService {

    fun save(tournamentDto: CreateTournamentInput): Tournament

    fun partialUpdate(tournamentDto: UpdateTournamentInput): Tournament

    fun findAll(): MutableList<Tournament>

    fun findOne(id: String): Optional<Tournament>

    fun delete(id: String): Boolean
}
