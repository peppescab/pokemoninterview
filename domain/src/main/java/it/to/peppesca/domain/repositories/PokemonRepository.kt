package it.to.peppesca.domain.repositories

import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity


/**
 * Repository to interact with pokemons data.
 */
interface PokemonRepository {

    /**
     * Fetches a lists of pokemons.
     *
     * @returns a list of [PokemonEntity].
     */
    suspend fun fetchPokemons(offset: Int): List<PokemonEntity>

    /**
     * Fetches the pokemon details given the [pokemonId].
     *
     * @param pokemonId as the id of pokemon.
     * @returns a [PokemonDetailEntity].
     */
    suspend fun catchPokemon(pokemonId: Int): PokemonDetailEntity
}
