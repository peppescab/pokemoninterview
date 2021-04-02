package it.to.peppesca.data.datasource.interfaces

import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse

/**
 *
 */
interface PokemonRemoteDataSource {

    suspend fun getPokemonList(offset: Int): PokemonsResponse

    suspend fun getSinglePokemon(pokemonId: Long): PokemonDetailResponse

}