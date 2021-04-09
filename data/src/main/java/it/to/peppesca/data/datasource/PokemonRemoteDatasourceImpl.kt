package it.to.peppesca.data.datasource

import it.to.peppesca.data.api.PokemonApi
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse
import it.to.peppesca.domain.common.GeneralValues.SINGLE_PAGE_LIMIT

/**
 * Datasource for handling remote resources.
 */
class PokemonRemoteDatasourceImpl(private val pokemonApi: PokemonApi) : PokemonRemoteDataSource {

    override suspend fun getPokemonList(offset: Int): PokemonsResponse {
        return pokemonApi.getPokemonList(offset, SINGLE_PAGE_LIMIT)
    }

    override suspend fun getSinglePokemon(pokemonId: Int): PokemonDetailResponse {
        return pokemonApi.getPokemonDetail(pokemonId)
    }
}