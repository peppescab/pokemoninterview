package it.to.peppesca.domain.repositories

import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonShortDetailEntity
import kotlinx.coroutines.flow.Flow


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
     * @returns a [PokemonShortDetailEntity].
     */
    suspend fun catchPokemon(pokemonName: String): PokemonShortDetailEntity


    //suspend fun getPagedPokemons(pageSize: Int): PagingData<PokemonEntity>
}