package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.graphql.input.UpdateTournamentInput
import java.util.*


interface TournamentService {

    fun save(tournamentDto: CreateTournamentInput): Tournament

    fun partialUpdate(tournamentDto: UpdateTournamentInput): Tournament

    fun findAll(): MutableList<Tournament>

    fun findOne(id: String): Optional<Tournament>

    fun delete(id: String): Boolean
}
