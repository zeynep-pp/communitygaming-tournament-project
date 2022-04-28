package com.communitygaming.tournamentproject.service.mapper

import com.communitygaming.tournamentproject.domain.Tournament
import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.graphql.type.TournamentType
import org.mapstruct.Mapper

import org.mapstruct.ReportingPolicy



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
uses = [UserMapper::class])
interface TournamentMapper : EntityMapper<CreateTournamentInput, Tournament> {
}


