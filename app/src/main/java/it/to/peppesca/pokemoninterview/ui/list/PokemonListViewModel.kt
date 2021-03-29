package it.to.peppesca.pokemoninterview.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.uniflow.android.AndroidDataFlow
import it.to.peppesca.domain.usecase.GetPokemonListUseCase
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonState
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonShortEntityToPokemonModelMapper
import it.to.peppesca.pokemoninterview.utils.Lce
import kotlinx.coroutines.launch


class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val pokemonEntityeToPokemonModelMapper: PokemonShortEntityToPokemonModelMapper
) : AndroidDataFlow() {

    val pokemonList = MutableLiveData<Lce<List<PokemonModel>>>()

    fun loadPokemons() {
        viewModelScope.launch {
            pokemonList.postValue(
                Lce.success(
                    pokemonEntityeToPokemonModelMapper.map(
                        getPokemonListUseCase.execute()
                    )
                )
            )
        }
    }

    fun fetchPokemons() = action(
        onAction = {
            setState(PokemonState.Loading)
            val pokemoList = pokemonEntityeToPokemonModelMapper.map(getPokemonListUseCase.execute())
            setState(PokemonState.PokemonList(pokemoList))
        }, onError = { ex, _ ->
            setState(PokemonState.Failed(ex))
        }
    )

}