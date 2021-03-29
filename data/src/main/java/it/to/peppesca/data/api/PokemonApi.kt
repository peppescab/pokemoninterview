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
     * @param limit as the max number of pokemon required.
     * @param offset as the offset number of starting.
     */
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: String?,
        @Query("offset") offset: String?
    ): PokemonsResponse

    /**
     * Fetches the pokemon of a particular  [pokemonName].
     *
     * @param pokemonName as pokemon name.
     */
    @GET("pokemon/{pokemon_name}/")
    suspend fun getPokemonDetail(@Path("pokemon_name") pokemonName: String): PokemonDetailResponse
}