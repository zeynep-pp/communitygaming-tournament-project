package com.communitygaming.tournamentproject.service.mapper

import com.communitygaming.tournamentproject.domain.TournamentDomain
import com.communitygaming.tournamentproject.graphql.input.CreateTournamentInput
import com.communitygaming.tournamentproject.graphql.type.Tournament
import org.mapstruct.Mapper

import org.mapstruct.ReportingPolicy



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
uses = [UserMapper::class])
interface TournamentMapper : EntityMapper<CreateTournamentInput,TournamentDomain, Tournament> {
}


