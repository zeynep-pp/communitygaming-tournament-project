package com.communitygaming.tournamentproject.service.mapper

import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper : EntityMapper<RegisterInput, User> {
}

