package it.to.peppesca.pokemoninterview.ui.list

import androidx.lifecycle.MutableLiveData
import io.uniflow.android.AndroidDataFlow
import it.to.peppesca.domain.usecase.GetPokemonListUseCase
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapper
import it.to.peppesca.pokemoninterview.utils.Lce


class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val pokemonDetailEntityToPokemonModelMapper: PokemonDetailEntityToPokemonModelMapper
) : AndroidDataFlow() {

    val pokemonList = MutableLiveData<Lce<List<PokemonModel>>>()
/*
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
    }*/

    fun fetchPokemons() = action(
        onAction = {
            setState(PokemonListState.Loading)
            val pokemoList = pokemonDetailEntityToPokemonModelMapper.map(getPokemonListUseCase.execute())
            setState(PokemonListState.PokemonList(pokemoList))
        }, onError = { ex, _ ->
            setState(PokemonListState.Failed(ex))
        }
    )

}