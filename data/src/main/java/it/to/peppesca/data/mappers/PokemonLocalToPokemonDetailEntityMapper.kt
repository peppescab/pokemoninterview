package it.to.peppesca.data.mappers

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonLocalToPokemonDetailEntityMapper :
    Mapper<PokemonLocal, PokemonDetailEntity>

class PokemonLocalToPokemonDetailEntityMapperImpl : PokemonLocalToPokemonDetailEntityMapper {

    override fun map(input: PokemonLocal): PokemonDetailEntity = with(input) {
        PokemonDetailEntity(
            id = id,
            urlImage = urlImage,
            name = name,
            type = type,
            baseExp = baseExp,
            weight = weight,
            height = height
        )
    }
}