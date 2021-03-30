package it.to.peppesca.domain.usecase

import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.domain.usecase.base.ActionResultUseCase

/**
 *
 */
class GetPokemonByIdUseCase(private val pokemonRepository: PokemonRepository) :
    ActionResultUseCase<Long, PokemonDetailEntity> {

    override suspend fun execute(pokemonId: Long): PokemonDetailEntity {

        return pokemonRepository.catchPokemon(pokemonId)

    }
}