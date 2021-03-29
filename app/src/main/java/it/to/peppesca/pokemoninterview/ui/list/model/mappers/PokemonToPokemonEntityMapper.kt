package it.to.peppesca.pokemoninterview.ui.list.model.mappers

import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonShortDetailEntity
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonShortEntityToPokemonModelMapper :
    Mapper<PokemonShortDetailEntity, PokemonModel>

class PokemonShortEntityToPokemonModelMapperImpl : PokemonShortEntityToPokemonModelMapper {

    override fun map(input: PokemonShortDetailEntity): PokemonModel = with(input) {
        PokemonModel(
            id.toString(),
            urlImage,
            name.capitalize()
        )
    }
}