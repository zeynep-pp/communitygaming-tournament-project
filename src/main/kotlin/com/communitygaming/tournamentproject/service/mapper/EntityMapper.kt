package com.communitygaming.tournamentproject.service.mapper

import org.mapstruct.BeanMapping
import org.mapstruct.MappingTarget
import org.mapstruct.Named
import org.mapstruct.NullValuePropertyMappingStrategy

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param D DTO type paratournament.
 * @param E Entity type paratournament.
 */

interface EntityMapper<I,E, D> {

    fun toEntity(dto: I): E

    fun toDto(entity: E): D

    fun toEntity(dtoList: MutableList<I>): MutableList<E>

    fun toDto(entityList: MutableList<E>): MutableList<D>
        
    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(@MappingTarget entity: E, dto: I)
}
