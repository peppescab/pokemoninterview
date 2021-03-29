package it.to.peppesca.domain.usecase

import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.domain.usecase.base.ResultUseCase

/**
 *
 */
class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) :
    ResultUseCase<List<PokemonDetailEntity>> {

    override suspend fun execute(): List<PokemonDetailEntity> {

        return pokemonRepository.fecthPokemons().map { pokemonEntity ->
            pokemonRepository.catchPokemon(pokemonEntity.id)
        }
    }
}