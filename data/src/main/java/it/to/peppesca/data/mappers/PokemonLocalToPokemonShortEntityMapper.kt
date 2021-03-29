package it.to.peppesca.data.mappers

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonShortDetailEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonLocalToPokemonShortEntityMapper :
    Mapper<PokemonLocal, PokemonShortDetailEntity>

class PokemonLocalToPokemonShortEntityMapperImpl : PokemonLocalToPokemonShortEntityMapper {

    override fun map(input: PokemonLocal): PokemonShortDetailEntity = with(input) {
        PokemonShortDetailEntity(
            id = this.id,
            urlImage = this.urlImage,
            name = this.name
        )
    }
}