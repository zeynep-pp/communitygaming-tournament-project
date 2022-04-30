package com.tournament.kotlingraphql.service.impl

import com.tournament.kotlingraphql.entity.User
import com.tournament.kotlingraphql.graphql.input.CreateTournamentInput
import com.tournament.kotlingraphql.entity.Tournament
import com.tournament.kotlingraphql.graphql.input.UpdateTournamentInput
import com.tournament.kotlingraphql.repository.TournamentRepository
import com.tournament.kotlingraphql.service.TournamentService
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class TournamentServiceImpl(
    private val tournamentRepository: TournamentRepository,
    private val userService: UserServiceImpl,
    private val mongoOperations: MongoOperations

) : TournamentService {

    private val log = LoggerFactory.getLogger(javaClass);

    override fun save(tournamentDto: CreateTournamentInput): Tournament {
        log.debug("Request to save Tournament: $tournamentDto")
        var tournament = Tournament(UUID.randomUUID().toString(),tournamentDto.userId,tournamentDto.tournamentName,tournamentDto.perTeamNumber)
        tournamentRepository.save(tournament)
        return tournament
    }



    override fun partialUpdate(tournamentDto: UpdateTournamentInput): Tournament {
        log.debug("Request to  update Tournament: $tournamentDto")
        val tournament = tournamentRepository.findById(tournamentDto.id)
        tournament.ifPresent {
            it.tournamentName = tournamentDto.tournamentName
            it.userId= tournamentDto.userId
            it.perTeamNumber=tournamentDto.perTeamNumber
            tournamentRepository.save(it)
        }
        return tournament.get()

    }

   override fun findAll(): MutableList<Tournament> {
        log.debug("Request to get all Tournaments")
        simulateSlowService();
        return tournamentRepository.findAll()
    }

    private fun simulateSlowService() {
        try {
            val time = 3000L
            Thread.sleep(time)
        } catch (e: InterruptedException) {
            throw IllegalStateException(e)
        }
    }

    override fun findOne(id: String): Optional<Tournament> {
        log.debug("Request to get Tournament by id: $id")
        return tournamentRepository.findById(id)
    }

    override fun delete(id: String): Boolean  {
        log.debug("Request to delete Tournament by id : $id")
        tournamentRepository.deleteById(id)
        return true
    }

    fun getTournaments(userId: String): List<Tournament> {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        return mongoOperations.find(query, Tournament::class.java)
    }

}
