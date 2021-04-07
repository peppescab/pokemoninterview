package it.to.peppesca.domain.usecase

import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.utils.POKEMON_DETAIL_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_ID_STUB
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [GetPokemonByIdUseCase]
 */
class GetPokemonByIdUseCaseTest {

    private val pokemonRepository: PokemonRepository = mockk()
    private val target = GetPokemonByIdUseCase(pokemonRepository)

    @Test
    fun `given a pokemon, when asked it by id,then return it`() {
        coEvery { pokemonRepository.catchPokemon(POKEMON_ID_STUB) } returns POKEMON_DETAIL_ENTITY_STUB

        runBlocking {
            target.execute(POKEMON_ID_STUB) `should be equal to` POKEMON_DETAIL_ENTITY_STUB
        }
    }

}