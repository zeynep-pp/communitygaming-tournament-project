package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.graphql.type.Tournament
import java.util.*


interface TournamentService {

    fun save(tournamentDto: CreateTournamentInput): Tournament

    fun partialUpdate(id: String,tournamentDto: CreateTournamentInput): Optional<Tournament>

    fun findAll(): MutableList<Tournament>

    fun findOne(id: String): Optional<Tournament>

    fun delete(id: String): Boolean
}
