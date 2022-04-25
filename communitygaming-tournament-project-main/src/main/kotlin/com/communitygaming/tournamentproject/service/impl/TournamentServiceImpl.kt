package com.communitygaming.tournamentproject.service.impl

import com.communitygaming.tournamentproject.graphql.input.TournamentInput
import com.communitygaming.tournamentproject.repository.TournamentRepository
import com.communitygaming.tournamentproject.service.TournamentService
import com.communitygaming.tournamentproject.service.mapper.TournamentMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
class TournamentServiceImpl(
    private val tournamentRepository: TournamentRepository,
    private val tournamentMapper: TournamentMapper

) : TournamentService {

    private val log = LoggerFactory.getLogger(javaClass);


    override fun save(tournamentDto: TournamentInput): TournamentInput {
        log.debug("Request to save Tournament: $tournamentDto")
        var tournament = tournamentMapper.toEntity(tournamentDto)
        tournament = tournamentRepository.save(tournament)
        return tournamentMapper.toDto(tournament)
    }


    override fun partialUpdate(id: String,tournamentDto: TournamentInput): Optional<TournamentInput> {
        log.debug("Request to partial update Tournament: $tournamentDto")

        return tournamentRepository.findById(id)
            .map {
                tournamentMapper.partialUpdate(it, tournamentDto)
                it
            }
            .map { tournamentRepository.save(it) }
            .map { tournamentMapper.toDto(it) }

    }


   // @Cacheable("tournaments")
   override fun findAll(): MutableList<TournamentInput> {
        log.debug("Request to get all Tournaments")
        simulateSlowService();
        return tournamentRepository.findAll()
            .mapTo(mutableListOf(), tournamentMapper::toDto)
    }

    private fun simulateSlowService() {
        try {
            val time = 3000L
            Thread.sleep(time)
        } catch (e: InterruptedException) {
            throw IllegalStateException(e)
        }
    }

    override fun findOne(id: String): Optional<TournamentInput> {
        log.debug("Request to get Tournament by id: $id")
        return tournamentRepository.findById(id).map(tournamentMapper::toDto)
    }

    override fun delete(id: String) {
        log.debug("Request to delete Tournament by id : $id")
        tournamentRepository.deleteById(id)
    }
}
