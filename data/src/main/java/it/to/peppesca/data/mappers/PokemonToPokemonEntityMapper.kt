package it.to.peppesca.data.mappers

import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonShortDetailEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonDetailResponseToPokemonEntityMapper :
    Mapper<PokemonDetailResponse, PokemonShortDetailEntity>

class PokemonDetailResponseToPokemonEntityMapperImpl : PokemonDetailResponseToPokemonEntityMapper {

    override fun map(input: PokemonDetailResponse): PokemonShortDetailEntity = with(input) {
        PokemonShortDetailEntity(
            this.id,
            this.sprites.frontDefault ?: "",
            this.name
        )
    }
}