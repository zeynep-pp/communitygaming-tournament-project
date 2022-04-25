package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.graphql.input.TournamentInput
import com.communitygaming.tournamentproject.repository.TournamentRepository
import com.communitygaming.tournamentproject.service.mapper.TournamentMapper
import org.springframework.cache.annotation.Cacheable
import java.util.*
import org.springframework.stereotype.Component

@Component
class TournamentService2 (
    private val tournamentRepository: TournamentRepository,
    private val tournamentMapper: TournamentMapper,
)  {
    fun save(tournamentDto: TournamentInput): TournamentInput {
        var tournament = tournamentMapper.toEntity(tournamentDto)
        tournament = tournamentRepository.save(tournament)
        return tournamentMapper.toDto(tournament)
    }

}