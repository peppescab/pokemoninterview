package it.to.peppesca.data.mappers

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonLocalToPokemonEntityMapper :
    Mapper<PokemonLocal, PokemonEntity>

class PokemonLocalToPokemonEntityMapperImpl : PokemonLocalToPokemonEntityMapper {

    override fun map(input: PokemonLocal): PokemonEntity = with(input) {
        PokemonEntity(
            id = id,
            name = name
        )
    }
}