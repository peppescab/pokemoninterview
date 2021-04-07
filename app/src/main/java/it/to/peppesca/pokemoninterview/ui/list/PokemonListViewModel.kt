package it.to.peppesca.pokemoninterview.ui.list

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import io.uniflow.android.AndroidDataFlow
import it.to.peppesca.domain.usecase.GetPokemonListPagedUseCase
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonListState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapper
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

/**
 * Viewmodel for [PokemonListFragment]
 */
class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListPagedUseCase,
    private val mapper: PokemonDetailEntityToPokemonModelMapper
) : AndroidDataFlow() {

    /**
     * Tracks the value of the search text for filtering the pokemon list.
     */
    val searchText = MutableLiveData("")

    val searchMediator = MediatorLiveData<PagingData<PokemonModel>>()

    var pokemonList : PagingData<PokemonModel>? = null

    private val apartmentListObserver = Observer<Any> {
        pokemonList?.let { lceList ->
            filterApartmentList(searchText.value.orEmpty(),lceList).let{
                searchMediator.value = it
            }
        }
    }

    init {
        searchMediator.addSource(searchText, apartmentListObserver)
    }

    fun fetchPokemons() {

        action(
            onAction = {
                setState(PokemonListState.Loading)
                val pokem = getPokemonListUseCase.execute().cachedIn(viewModelScope).map { pagingData ->
                    pagingData.map { mapper.map(it) }
                }
                pokem.collectLatest {
                    val listFiltered = filterApartmentList(searchText.value.orEmpty(),it)
                        setState(PokemonListState.PokemonList(listFiltered))
                    pokemonList = listFiltered
                }
            },
            onError = { ex, _ ->
                setState(PokemonListState.Failed(ex))
            }
        )
    }

    private fun filterApartmentList(key: String,listToFilter:PagingData<PokemonModel>): PagingData<PokemonModel> = if (key.isEmpty()) {
        listToFilter
    } else {
        listToFilter.filter { it.name.contains(key, true) }
    }

}
