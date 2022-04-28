package com.communitygaming.tournamentproject.repository

import com.communitygaming.tournamentproject.domain.TournamentDomain
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TournamentRepository : MongoRepository<TournamentDomain, String>

