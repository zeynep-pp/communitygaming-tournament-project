

package com.tournament.kotlingraphql.repository

import com.tournament.kotlingraphql.entity.Tournament
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TournamentRepository : MongoRepository<Tournament, String>