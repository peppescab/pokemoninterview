package it.to.peppesca.domain.usecase

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.utils.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.coInvoking
import org.amshove.kluent.shouldThrow
import org.junit.Test

/**
 * Test class for [GetPokemonListUseCase]
 */
@OptIn(ExperimentalCoroutinesApi::class)
class GetPokemonListUseCaseTest {

    private val pokemonRepository: PokemonRepository = mockk()
    private val target = GetPokemonListUseCase(pokemonRepository)

    @Test
    fun `given a pokemon list , when asked it by id,then return it`() {
        coEvery { pokemonRepository.fetchPokemons(POKEMON_STARTING_ID) } returns LIST_POKEMON_ENTITY
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_ENTITY_STUB
        coEvery { pokemonRepository.catchPokemon(3) } returns POKEMON_DETAIL_ENTITY_STUB_1
        coEvery { pokemonRepository.catchPokemon(4) } returns POKEMON_DETAIL_ENTITY_STUB_2

        runBlockingTest {
            target.execute(GetPokemonListUseCase.Params(POKEMON_STARTING_ID)) `should be equal to` POKEMON_PAGED_ENTITY_STUB
        }
    }

    @Test
    fun `given an error while fetching pokemon list , when asked it by id,then return error`() {
        coEvery { pokemonRepository.fetchPokemons(POKEMON_STARTING_ID) } throws  POKEMON_EXCEPTION
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_ENTITY_STUB

        runBlockingTest {
            coInvoking {  target.execute(GetPokemonListUseCase.Params(POKEMON_STARTING_ID))} shouldThrow  POKEMON_EXCEPTION
        }
    }

    @Test
    fun `given an error while catching a pokemon , when asked it by id,then return error`() {
        coEvery { pokemonRepository.fetchPokemons(POKEMON_STARTING_ID) } returns  LIST_POKEMON_ENTITY
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } throws POKEMON_EXCEPTION

        runBlockingTest {
            coInvoking {  target.execute(GetPokemonListUseCase.Params(POKEMON_STARTING_ID))} shouldThrow  POKEMON_EXCEPTION
        }
    }

}