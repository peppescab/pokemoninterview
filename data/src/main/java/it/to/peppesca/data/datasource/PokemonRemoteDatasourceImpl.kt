package it.to.peppesca.data.datasource

import it.to.peppesca.data.api.PokemonApi
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse

/**
 *
 */
class PokemonRemoteDatasourceImpl(private val pokemonApi: PokemonApi) : PokemonRemoteDataSource {

    override suspend fun getPokemonList(): PokemonsResponse {
        return pokemonApi.getPokemonList("100", "0")
    }

    override suspend fun getSinglePokemon(pokemonName: String): PokemonDetailResponse {
        return pokemonApi.getPokemonDetail(pokemonName)
    }
/*
    override fun getPagedPokemons(pageSize: Int): PagingData<String, PokemonResult> {
        return PageKeyedSubredditPagingSource(pokemonApi)
    }*/

}