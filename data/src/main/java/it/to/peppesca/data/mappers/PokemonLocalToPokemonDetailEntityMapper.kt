package it.to.peppesca.data.mappers

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonDetailEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonLocalToPokemonDetailEntityMapper :
    Mapper<PokemonLocal, PokemonDetailEntity>

class PokemonLocalToPokemonDetailEntityMapperImpl : PokemonLocalToPokemonDetailEntityMapper {

    override fun map(input: PokemonLocal): PokemonDetailEntity = with(input) {
        PokemonDetailEntity(
            id = this.id,
            urlImage = this.urlImage,
            name = this.name
        )
    }
}