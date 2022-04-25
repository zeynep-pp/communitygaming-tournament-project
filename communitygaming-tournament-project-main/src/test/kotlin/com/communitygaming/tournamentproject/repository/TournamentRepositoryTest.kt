package com.communitygaming.tournamentproject.repository

import com.communitygaming.tournamentproject.domain.Tournament
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class TournamentRepositoryTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var tournamentRepository: TournamentRepository

    @Test
    fun whenFindAll_thenReturnTournaments() {
        val tournament = Tournament()
        tournament.tournamentName= "Test"

        entityManager.persist(tournament)
        entityManager.flush()

        val foundTournaments = tournamentRepository.findAll()
        assertThat(tournament == foundTournaments[0])
    }

}
