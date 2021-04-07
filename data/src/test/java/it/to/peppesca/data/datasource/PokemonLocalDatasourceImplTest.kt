package it.to.peppesca.data.datasource

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.data.dao.PokemonDao
import it.to.peppesca.utils.*
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonLocalDatasourceImpl]
 */
class PokemonLocalDatasourceImplTest {

    var pokemonDao: PokemonDao = mockk()
    val target = PokemonLocalDatasourceImpl(pokemonDao)

    @Test
    fun `given a list of pokemons, when all are request, then return the list`() {
        coEvery { pokemonDao.getAll() } returns LIST_POKEMON_LOCAL
        runBlocking {
            target.getPokemonList() `should be equal to` LIST_POKEMON_LOCAL
        }
    }

    @Test
    fun `given an empty list of pokemons, when all are request, then return an empty list`() {
        coEvery { pokemonDao.getAll() } returns emptyList()
        runBlocking {
            target.getPokemonList() `should be equal to` emptyList()
        }
    }

    @Test
    fun `given a particular pokemon, when its id is requested, then return it`() {
        coEvery { pokemonDao.getPokemonById(POKEMON_ID_STUB) } returns POKEMON_LOCAL_STUB
        runBlocking {
            target.getSinglePokemon(POKEMON_ID_STUB) `should be equal to` POKEMON_LOCAL_STUB
        }
    }

    @Test
    fun `given a list of pokemons between two ids, when they are request, then return that list`() {
        coEvery { pokemonDao.getPokemonRange(POKEMON_STARTING_ID, POKEMON_ENDING_ID) } returns LIST_IN_RANGE_POKEMON_LOCAL
        runBlocking {
            target.getPokemonRanged(POKEMON_STARTING_ID) `should be equal to` LIST_IN_RANGE_POKEMON_LOCAL
        }
    }

}