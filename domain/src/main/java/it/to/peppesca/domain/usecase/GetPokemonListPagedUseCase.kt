package it.to.peppesca.domain.usecase

import androidx.paging.*
import it.to.peppesca.domain.common.GeneralValues.SINGLE_PAGE_LIMIT
import it.to.peppesca.domain.common.GeneralValues.STARTING_PAGE
import it.to.peppesca.domain.common.GeneralValues.TOTAL_PAGES
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.usecase.base.ResultUseCase
import kotlinx.coroutines.flow.Flow

/**
 * This use case return a [PagingData] result for [PokemonDetailEntity].
 */
class GetPokemonListPagedUseCase(private val getPokemonListUseCase: GetPokemonListUseCase) :
    ResultUseCase<Flow<PagingData<PokemonDetailEntity>>> {


    override suspend fun execute(): Flow<PagingData<PokemonDetailEntity>> {
        return Pager(PagingConfig(pageSize = SINGLE_PAGE_LIMIT)) {
            PokemonPagingDataSource(getPokemonListUseCase)
        }.flow
    }

    private inner class PokemonPagingDataSource(
        private val getPokemonListUseCase: GetPokemonListUseCase
    ) : PagingSource<Int, PokemonDetailEntity>() {

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonDetailEntity> {
            return try {
                val page = params.key ?: STARTING_PAGE
                val response = getPokemonListUseCase.execute(GetPokemonListUseCase.Params(page))

                LoadResult.Page(
                    data = response.pokemons,
                    prevKey = if (page == STARTING_PAGE) null else page - SINGLE_PAGE_LIMIT,
                    nextKey = if (page < TOTAL_PAGES)
                        response.page.plus(SINGLE_PAGE_LIMIT) else null
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }

        override fun getRefreshKey(state: PagingState<Int, PokemonDetailEntity>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
                // multiple pages, the initial load will still load items centered around
                // anchorPosition. This also prevents needing to immediately launch prepend due to
                // prefetchDistance.
                state.closestPageToPosition(anchorPosition)?.prevKey
            }
        }
    }

}

