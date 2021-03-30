package it.to.peppesca.data.datasource.interfaces

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse
import kotlinx.coroutines.flow.Flow

/**
 *
 */
interface PokemonLocalDataSource {

    suspend fun getPokemonList(): List<PokemonLocal>

    suspend fun getSinglePokemon(pokemonId: Long): PokemonLocal?

    suspend fun insertPokemon(pokemonLocal : PokemonLocal)
}