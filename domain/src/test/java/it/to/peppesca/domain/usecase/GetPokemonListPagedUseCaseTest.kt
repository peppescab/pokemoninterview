package it.to.peppesca.domain.usecase

import androidx.paging.PagingSource.LoadParams.Refresh
import androidx.paging.PagingSource.LoadResult.Page
import io.mockk.coEvery
import io.mockk.mockk
import it.to.peppesca.utils.LIST_POKEMON_DETAIL_ENTITY
import it.to.peppesca.utils.POKEMON_ENDING_ID
import it.to.peppesca.utils.POKEMON_PAGED_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_STARTING_INDEX
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 *  Test class for [GetPokemonListPagedUseCase]
 */
@OptIn(ExperimentalCoroutinesApi::class)
class GetPokemonListPagedUseCaseTest {

    private val getPokemonListUseCase: GetPokemonListUseCase = mockk()
    private val target = GetPokemonListPagedUseCase.PokemonPagingDataSource(getPokemonListUseCase)

    @Test
    fun `given a paged source of pokemons, when asked it,then return it`() {
        coEvery { getPokemonListUseCase.execute(GetPokemonListUseCase.Params(POKEMON_STARTING_INDEX)) } returns POKEMON_PAGED_ENTITY_STUB

        runBlockingTest {
            Page(LIST_POKEMON_DETAIL_ENTITY, prevKey = null, nextKey = POKEMON_ENDING_ID) `should be equal to`
                    target.load(Refresh(key = null, loadSize = LIST_POKEMON_DETAIL_ENTITY.size, placeholdersEnabled = false))
        }
    }

}