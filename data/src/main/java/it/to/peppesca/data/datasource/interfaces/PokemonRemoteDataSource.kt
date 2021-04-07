package it.to.peppesca.data.datasource.interfaces

import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse

/**
 * Interface for handling all interactions with remote newtwork.
 */
interface PokemonRemoteDataSource {
    /**
     * This function returns a list of pokemons from remote starting by a particular id.
     *
     * @param offset as the starting id for pokemon.
     */
    suspend fun getPokemonList(offset: Int): PokemonsResponse

    /**
     * This function returns a singular pokemon by its id.
     *
     * @param pokemonId as the id of the pokemon.
     */
    suspend fun getSinglePokemon(pokemonId: Int): PokemonDetailResponse

}