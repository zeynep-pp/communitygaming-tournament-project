package com.communitygaming.tournamentproject.service.mapper

import com.communitygaming.tournamentproject.domain.UserDomain
import com.communitygaming.tournamentproject.graphql.input.RegisterInput
import com.communitygaming.tournamentproject.graphql.type.User
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper : EntityMapper<RegisterInput, UserDomain, User> {
}

