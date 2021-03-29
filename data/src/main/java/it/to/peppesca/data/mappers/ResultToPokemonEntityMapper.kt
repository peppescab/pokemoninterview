package it.to.peppesca.data.mappers

import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface ResultToPokemonEntityMapper : Mapper<PokemonResult, PokemonEntity>

class ResultToPokemonEntityMapperImpl : ResultToPokemonEntityMapper {

    override fun map(input: PokemonResult): PokemonEntity = with(input) {
        PokemonEntity(
            this.name,
            extractId(this.url)
        )
    }

    private fun extractId(stringToExtract: String): String =
        stringToExtract.dropLast(1).split("/").last()
}