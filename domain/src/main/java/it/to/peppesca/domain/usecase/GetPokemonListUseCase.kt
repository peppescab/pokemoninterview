package it.to.peppesca.domain.usecase

import it.to.peppesca.domain.models.PokemonShortDetailEntity
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.domain.usecase.base.ResultUseCase
import kotlinx.coroutines.flow.Flow

/**
 *
 */
class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) :
    ResultUseCase<List<PokemonShortDetailEntity>> {

    override suspend fun execute(): List<PokemonShortDetailEntity> {

        return pokemonRepository.fecthPokemons().map { pokemonEntity ->
            pokemonRepository.catchPokemon(pokemonEntity.id)
        }
    }
}