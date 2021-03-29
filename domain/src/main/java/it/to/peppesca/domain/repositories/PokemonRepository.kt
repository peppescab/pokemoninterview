package it.to.peppesca.domain.repositories

import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonDetailEntity


/**
 * Repository to interact with apartments data.
 */
interface PokemonRepository {

    /**
     * Fetches a lists of pokemons.
     *
     * @returns a list of [PokemonEntity].
     */
    suspend fun fecthPokemons(): List<PokemonEntity>

    /**
     * Fetches the pokemon details given the [pokemonName].
     *
     * @param pokemonName as the pokemon name.
     * @returns a [PokemonDetailEntity].
     */
    suspend fun catchPokemon(pokemonName: String): PokemonDetailEntity


    //suspend fun getPagedPokemons(pageSize: Int): PagingData<PokemonEntity>
}