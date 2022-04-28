package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import java.util.*


interface TournamentService {

    fun save(tournamentDto: CreateTournamentInput): CreateTournamentInput

    fun partialUpdate(id: String,tournamentDto: CreateTournamentInput): Optional<CreateTournamentInput>

    fun findAll(): MutableList<CreateTournamentInput>

    fun findOne(id: String): Optional<CreateTournamentInput>

    fun delete(id: String): Boolean
}
