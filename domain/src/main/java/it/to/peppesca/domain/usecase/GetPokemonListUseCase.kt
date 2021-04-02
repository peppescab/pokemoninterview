package it.to.peppesca.domain.usecase

import it.to.peppesca.domain.models.PokemonsPagedEntity
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.domain.usecase.base.ActionResultUseCase

/**
 *
 */
class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) :
    ActionResultUseCase<GetPokemonListUseCase.Params, PokemonsPagedEntity> {

    override suspend fun execute(params: Params) = PokemonsPagedEntity (
        pokemons = pokemonRepository.fetchPokemons(params.start).map { pokemonEntity ->
            pokemonRepository.catchPokemon(pokemonEntity.id)
        },
        page = params.start
    )

    data class Params(val start: Int, val limit: Int)
}