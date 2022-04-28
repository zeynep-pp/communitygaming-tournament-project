package com.communitygaming.tournamentproject.service

import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.repository.TournamentRepository
import com.communitygaming.tournamentproject.service.impl.TournamentServiceImpl
import com.communitygaming.tournamentproject.service.mapper.TournamentMapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TournamentServiceTest {

    @MockK
    lateinit var tournamentRepository: TournamentRepository

    @MockK
    lateinit var tournamentMapper: TournamentMapper

    @InjectMockKs
    lateinit var tournamentServiceImpl: TournamentServiceImpl

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun whenGetAllTournaments_ThenReturnTournaments() {
        val tournament = Tournament("1", "Test name")
        val tournamentDTO = CreateTournamentInput( "Test name")

        //given
        every { tournamentRepository.findAll() } returns listOf(tournament)
        every { tournamentMapper.toDto(tournament) } returns tournamentDTO

        //when
        val result = tournamentServiceImpl.findAll();

        //then

        verify(exactly = 1) { tournamentRepository.findAll() }

        assertEquals(tournamentDTO.tournamentName, result[0].tournamentName)
    }
}
