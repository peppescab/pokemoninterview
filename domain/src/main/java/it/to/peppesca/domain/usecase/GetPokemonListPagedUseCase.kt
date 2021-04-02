package it.to.peppesca.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.usecase.base.ResultUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Repository class that works with local and remote data sources.
 */
class GetPokemonListPagedUseCase(private val getPokemonListUseCase: GetPokemonListUseCase) :
    ResultUseCase<Flow<PagingData<PokemonDetailEntity>>> {

    private val SINGLE_PAGE_LIMIT = 20
    private val TOTAL_PAGES = 1118

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
                val page = params.key ?: 0
                val response = getPokemonListUseCase.execute(GetPokemonListUseCase.Params(page, params.loadSize))

                LoadResult.Page(
                    data = response.pokemons,
                    prevKey = if (page == 0) null else page - SINGLE_PAGE_LIMIT,
                    nextKey = if (page < TOTAL_PAGES)
                        response.page.plus(SINGLE_PAGE_LIMIT) else null
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

}

