package it.to.peppesca.data.datasource

import it.to.peppesca.data.api.PokemonApi
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse

//TODO add documentation
/**
 *
 */
class PokemonRemoteDatasourceImpl(private val pokemonApi: PokemonApi) : PokemonRemoteDataSource {

    override suspend fun getPokemonList(offset: Int): PokemonsResponse {
        return pokemonApi.getPokemonList(offset)
    }

    override suspend fun getSinglePokemon(pokemonId: Long): PokemonDetailResponse {
        return pokemonApi.getPokemonDetail(pokemonId)
    }
}