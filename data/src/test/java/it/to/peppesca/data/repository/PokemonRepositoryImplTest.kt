package it.to.peppesca.data.repository

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.mappers.*
import it.to.peppesca.utils.*
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonRepositoryImpl]
 */
class PokemonRepositoryImplTest {

    private val pokemonRemoteDataSource: PokemonRemoteDataSource = mockk()
    private val pokemonLocalDataSource: PokemonLocalDataSource = mockk()

    private val target = PokemonRepositoryImpl(
        pokemonRemoteDataSource, pokemonLocalDataSource, PokemonResultToPokemonEntityMapperImpl(),
        PokemonLocalToPokemonDetailEntityMapperImpl(), PokemonDetailResponseToPokemonLocalMapperImpl(), PokemonLocalToPokemonEntityMapperImpl(),
        PokemonDetailResponseToPokemonDetailEntityMapperImpl()
    )

    @Test
    fun `given an empty list of pokemon local, when asked to return pokemons,then return a pokemon list from remote`() {
        coEvery { pokemonLocalDataSource.getPokemonRanged(POKEMON_STARTING_ID) } returns emptyList()
        coEvery { pokemonRemoteDataSource.getPokemonList(POKEMON_STARTING_ID) } returns POKEMON_RESPONSE_STUB

        runBlocking {
            target.fetchPokemons(POKEMON_STARTING_ID) `should be equal to` LIST_POKEMON_ENTITY
        }

    }

    @Test
    fun `given a list of pokemon local, when asked to return pokemons,then return a pokemon list from local`() {
        coEvery { pokemonLocalDataSource.getPokemonRanged(POKEMON_STARTING_ID) } returns LIST_POKEMON_LOCAL
        coEvery { pokemonRemoteDataSource.getPokemonList(POKEMON_STARTING_ID) } returns POKEMON_RESPONSE_STUB

        runBlocking {
            target.fetchPokemons(POKEMON_STARTING_ID) `should be equal to` LIST_POKEMON_ENTITY_RANGE
        }

    }

    @Test
    fun `given a pokemon not present in local, when is asked,then insert the pokemon in local and return a pokemon from network`() {
        coEvery { pokemonLocalDataSource.getSinglePokemon(POKEMON_ID_STUB) } returns null
        coEvery { pokemonRemoteDataSource.getSinglePokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_RESPONSE_STUB
        coEvery { pokemonLocalDataSource.insertPokemon(POKEMON_LOCAL_STUB) } returns Unit

        runBlocking {
            target.catchPokemon(POKEMON_ID_STUB) `should be equal to` POKEMON_DETAIL_ENTITY_STUB
        }

    }

    @Test
    fun `given a pokemon present in local, when is asked,then return the pokemon from local`() {
        coEvery { pokemonLocalDataSource.getSinglePokemon(POKEMON_ID_STUB) } returns POKEMON_LOCAL_STUB
        coEvery { pokemonRemoteDataSource.getSinglePokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_RESPONSE_STUB

        runBlocking {
            target.catchPokemon(POKEMON_ID_STUB) `should be equal to` POKEMON_DETAIL_ENTITY_STUB
        }

    }


}