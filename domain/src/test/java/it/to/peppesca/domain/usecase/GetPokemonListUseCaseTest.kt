package it.to.peppesca.domain.usecase

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.utils.*
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [GetPokemonListUseCase]
 */
class GetPokemonListUseCaseTest {

    private val pokemonRepository: PokemonRepository = mockk()
    private val target = GetPokemonListUseCase(pokemonRepository)

    @Test
    fun `given a pokemon list , when asked it by id,then return it`() {
        coEvery { pokemonRepository.fetchPokemons(POKEMON_STARTING_ID) } returns LIST_POKEMON_ENTITY
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_ENTITY_STUB

        runBlocking {
            target.execute(GetPokemonListUseCase.Params(POKEMON_STARTING_ID)) `should be equal to` POKEMON_PAGED_ENTITY_STUB
        }
    }

}