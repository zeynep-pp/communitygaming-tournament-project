package com.communitygaming.tournamentproject.repository

import com.communitygaming.tournamentproject.domain.TournamentDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class TournamentDomainRepositoryTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var tournamentRepository: TournamentRepository

    @Test
    fun whenFindAll_thenReturnTournaments() {
        val tournamentDomain = TournamentDomain()
        tournamentDomain.tournamentName= "Test"

        entityManager.persist(tournamentDomain)
        entityManager.flush()

        val foundTournaments = tournamentRepository.findAll()
        assertThat(tournamentDomain == foundTournaments[0])
    }

}
