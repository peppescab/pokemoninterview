package it.to.peppesca.pokemoninterview.ui.list.model.mappers

import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonShortDetailEntity
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonEntityToPokemonModelMapper :
    Mapper<PokemonEntity, PokemonModel>

class PokemonEntityToPokemonModelMapperImpl : PokemonEntityToPokemonModelMapper {

    override fun map(input: PokemonEntity): PokemonModel = with(input) {
        PokemonModel(
            id.toString(),
            name.capitalize(),
            ""
        )
    }
}