package it.to.peppesca.pokemoninterview.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.paging.map
import io.uniflow.android.AndroidDataFlow
import it.to.peppesca.domain.usecase.GetPokemonListPagedUseCase
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapper
import it.to.peppesca.pokemoninterview.utils.LiveEvent
import kotlinx.coroutines.flow.map

class PokemonPagedListViewModel(
    private val getPokemonListUseCase: GetPokemonListPagedUseCase,
    private val mapper: PokemonDetailEntityToPokemonModelMapper
) : AndroidDataFlow() {

    /**
     * Event that signals state of pokemon list.
     */
    val stateLoading = MutableLiveData<Boolean>()

    fun fetchPokemons() = action(
        onAction = {
            setState(PokemonListState.Loading)
            val pokem = getPokemonListUseCase.execute().map { pagingData ->
                pagingData.map { mapper.map(it) }
            }
            setState(PokemonListState.PokemonList(pokem))

        }, onError = { ex, _ ->
            setState(PokemonListState.Failed(ex))
        }
    )

/*
        val pokemonsLive = MutableLiveData<PagingData<PokemonModel>>()

        fun loadPokemons() {
            viewModelScope.launch {
                getPokemonListPagedUseCase.execute().collectLatest {
                    pokemonsLive.postValue(it.map { poke -> mapper.map(poke) })
                }
            }
        }*/

/*
    private fun getMovieListStream(): Flow<PagingData<PokemonDetailEntity>> {
        return Pager(PagingConfig(20)) {
            PokemonPagingDataSource(getPokemonListUseCase)
        }.flow
    }*/

}
