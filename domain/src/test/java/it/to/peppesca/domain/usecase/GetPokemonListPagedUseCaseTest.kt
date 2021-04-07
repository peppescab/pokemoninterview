package it.to.peppesca.domain.usecase

import androidx.paging.map
import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.utils.POKEMON_DETAIL_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_FLOW_PAGED_POKEMON
import it.to.peppesca.utils.POKEMON_ID_STUB
import it.to.peppesca.utils.POKEMON_PAGED_ENTITY_STUB
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Ignore
import org.junit.Test

/**
 *  Test class for [GetPokemonListPagedUseCase]
 */
@Ignore("")
class GetPokemonListPagedUseCaseTest {

    private val getPokemonListUseCase: GetPokemonListUseCase = mockk()
    private val target = GetPokemonListPagedUseCase(getPokemonListUseCase)

    @Test
    fun `given a pokemon, when asked it by id,then return it`() {
        coEvery { getPokemonListUseCase.execute(GetPokemonListUseCase.Params(POKEMON_ID_STUB)) } returns POKEMON_PAGED_ENTITY_STUB

        runBlocking {
            target.execute().collectLatest {
                it.map { it `should be equal to` POKEMON_DETAIL_ENTITY_STUB }
            }
        }
    }

}