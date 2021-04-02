package it.to.peppesca.pokemoninterview.ui.list

import io.uniflow.android.AndroidDataFlow
import it.to.peppesca.domain.usecase.GetPokemonListUseCase
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapper


class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val pokemonDetailEntityToPokemonModelMapper: PokemonDetailEntityToPokemonModelMapper
) : AndroidDataFlow() {

    /**
     *
     */
    /*
    fun fetchPokemons() = action(
        onAction = {
            setState(PokemonListState.Loading)
            val pokemoList = pokemonDetailEntityToPokemonModelMapper.map(getPokemonListUseCase.execute(GetPokemonListUseCase.Params(0,25)))
           // setState(PokemonListState.PokemonList(pokemoList))
        }, onError = { ex, _ ->
            setState(PokemonListState.Failed(ex))
        }
    )*/

}