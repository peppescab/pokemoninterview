package it.to.peppesca.data.datasource

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.data.api.PokemonApi
import it.to.peppesca.utils.POKEMON_DETAIL_RESPONSE_STUB
import it.to.peppesca.utils.POKEMON_ID_STUB
import it.to.peppesca.utils.POKEMON_RESPONSE_STUB
import it.to.peppesca.utils.POKEMON_RESPONSE_STUB_EMPTY
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonRemoteDatasourceImpl]
 */
class PokemonRemoteDatasourceImplTest {

    private val pokemonApi: PokemonApi = mockk()

    val target = PokemonRemoteDatasourceImpl(pokemonApi)


    @Test
    fun `given a list of pokemons, when all are request, then return the list`() {
        coEvery { pokemonApi.getPokemonList(STUB_OFFSET,STUB_OFFSET) } returns POKEMON_RESPONSE_STUB
        runBlocking {
            target.getPokemonList(STUB_OFFSET) `should be equal to` POKEMON_RESPONSE_STUB
        }
    }


    @Test
    fun `given an empty list of pokemons, when all are request, then return an empty list`() {
        coEvery { pokemonApi.getPokemonList(STUB_OFFSET,STUB_OFFSET) } returns POKEMON_RESPONSE_STUB_EMPTY
        runBlocking {
            target.getPokemonList(STUB_OFFSET) `should be equal to` POKEMON_RESPONSE_STUB_EMPTY
        }
    }

    @Test
    fun `given a particular pokemon, when its id is requested, then return it`() {
        coEvery { pokemonApi.getPokemonDetail(POKEMON_ID_STUB) } returns POKEMON_DETAIL_RESPONSE_STUB
        runBlocking {
            target.getSinglePokemon(POKEMON_ID_STUB) `should be equal to` POKEMON_DETAIL_RESPONSE_STUB
        }
    }

    companion object {
        const val STUB_OFFSET = 20
    }


}