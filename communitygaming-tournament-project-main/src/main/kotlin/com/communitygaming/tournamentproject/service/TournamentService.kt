package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.TournamentInput
import java.util.*


interface TournamentService {

    fun save(tournamentDto: TournamentInput): TournamentInput

    fun partialUpdate(id: String,tournamentDto: TournamentInput): Optional<TournamentInput>

    fun findAll(): MutableList<TournamentInput>

    fun findOne(id: String): Optional<TournamentInput>

    fun delete(id: String)
}
