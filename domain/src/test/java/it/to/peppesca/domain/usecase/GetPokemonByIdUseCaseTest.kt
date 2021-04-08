package it.to.peppesca.domain.usecase

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.utils.POKEMON_DETAIL_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_EXCEPTION
import it.to.peppesca.utils.POKEMON_ID_STUB
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.coInvoking
import org.amshove.kluent.shouldThrow
import org.junit.Test

/**
 * Test class for [GetPokemonByIdUseCase]
 */
@OptIn(ExperimentalCoroutinesApi::class)
class GetPokemonByIdUseCaseTest {

    private val pokemonRepository: PokemonRepository = mockk()
    private val target = GetPokemonByIdUseCase(pokemonRepository)

    @Test
    fun `given a pokemon, when asked it by id,then return it`() {
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_ENTITY_STUB

        runBlockingTest {
            target.execute(POKEMON_ID_STUB) `should be equal to` POKEMON_DETAIL_ENTITY_STUB
        }
    }

    @Test
    fun `given an error while catching a  pokemon, when asked it by id,then return exception`() {
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } throws POKEMON_EXCEPTION

        runBlockingTest {
            coInvoking { target.execute(POKEMON_ID_STUB) } shouldThrow POKEMON_EXCEPTION
        }
    }

}