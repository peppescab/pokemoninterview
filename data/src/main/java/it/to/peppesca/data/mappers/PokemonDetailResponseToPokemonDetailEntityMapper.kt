package it.to.peppesca.data.mappers

import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonDetailEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonDetailResponseToPokemonDetailEntityMapper :
    Mapper<PokemonDetailResponse, PokemonDetailEntity>

class PokemonDetailResponseToPokemonDetailEntityMapperImpl : PokemonDetailResponseToPokemonDetailEntityMapper {

    override fun map(input: PokemonDetailResponse): PokemonDetailEntity = with(input) {
        PokemonDetailEntity(
            this.id,
            this.sprites.frontDefault ?: "",
            this.name
        )
    }
}