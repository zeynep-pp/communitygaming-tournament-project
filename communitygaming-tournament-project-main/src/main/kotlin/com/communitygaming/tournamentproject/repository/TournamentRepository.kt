package com.communitygaming.tournamentproject.repository

import com.communitygaming.tournamentproject.domain.Tournament
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TournamentRepository : MongoRepository<Tournament, String>

