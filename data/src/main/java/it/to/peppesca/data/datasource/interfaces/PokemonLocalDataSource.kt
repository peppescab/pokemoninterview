package it.to.peppesca.data.datasource.interfaces

import it.to.peppesca.data.dao.PokemonLocal

/**
 * Interface for handling all interactions with local database.
 */
interface PokemonLocalDataSource {
    /**
     * This function returns a list of all pokemons
     */
    suspend fun getPokemonList(): List<PokemonLocal>

    /**
     * This function returns a single pokemon by id.
     *
     * @param pokemonId is the id of pokemon.
     */
    suspend fun getSinglePokemon(pokemonId: Int): PokemonLocal?

    /**
     * This function returns a list of pokemon starting by a particular id.
     *
     * @param pokemonStart is the id of pokemon to start with.
     */
    suspend fun getPokemonRanged(pokemonStart: Int): List<PokemonLocal>

    /**
     * This function insert a pokemon inside the database.
     *
     * @param pokemonLocal is the pokemon to be inserted.
     */
    suspend fun insertPokemon(pokemonLocal: PokemonLocal)
}