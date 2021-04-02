package it.to.peppesca.data.api

import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.list.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Api for interacting with pokemons.
 */
interface PokemonApi {

    /**
     * Fetches a lists of pokemon with their ids.
     *
     * @param offset as the offset number of starting.
     */
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int?,
    ): PokemonsResponse

    /**
     * Fetches the pokemon of a particular  [pokemonId].
     *
     * @param pokemonId as pokemon id.
     */
    @GET("pokemon/{pokemon_id}/")
    suspend fun getPokemonDetail(@Path("pokemon_id") pokemonId: Long): PokemonDetailResponse
}